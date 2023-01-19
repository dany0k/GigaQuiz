package ru.vsu.cs.zmaev;


import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.Navigation;

import java.io.IOException;
import java.io.InputStream;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import ru.vsu.cs.zmaev.databinding.FragmentGameBinding;
import ru.vsu.cs.zmaev.model.AnswersViewModel;
import ru.vsu.cs.zmaev.model.ImageQuestion;
import ru.vsu.cs.zmaev.model.ThemeIDSender;

public class GameFragment extends Fragment {

    private static final int DELAY = 500;

    FragmentGameBinding binding = null;

    public AnswersViewModel sharedViewModel;
    private ThemeIDSender themeIDSender;
    public GameFragment() {
        super(R.layout.fragment_game);
    }

    List<ImageQuestion> questions;

    public ImageQuestion currentQuestion;
    public String correctAnswer;
    public List<String> answers;
    public int questionIndex = 0;

    private int correctAnswersCounter = 0;
    private int incorrectAnswersCounter = 0;
    private int answerIndex;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_game, container, false);
        sharedViewModel = new ViewModelProvider(getActivity()).get(AnswersViewModel.class);
        themeIDSender = new ViewModelProvider(getActivity()).get(ThemeIDSender.class);
        try {
            questions = getQuizTheme();
        } catch (IOException | URISyntaxException e) {
            e.printStackTrace();
        }

        randomizeQuestions();
        binding.setGame(GameFragment.this);
        binding.buttonFirstAnswer.setOnClickListener(v -> {
            answerIndex = 0;
            precessButton(v, binding.buttonFirstAnswer);
        });
        binding.buttonSecondAnswer.setOnClickListener(v -> {
            answerIndex = 1;
            precessButton(v, binding.buttonSecondAnswer);
        });
        binding.buttonThirdAnswer.setOnClickListener(v -> {
            answerIndex = 2;
            precessButton(v, binding.buttonThirdAnswer);
        });
        binding.buttonFourthAnswer.setOnClickListener(v -> {
            answerIndex = 3;
            precessButton(v, binding.buttonFourthAnswer);
        });

        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        binding.setLifecycleOwner(getViewLifecycleOwner());
        ((MainActivity) getActivity()).setDrawerLocked();
        binding.setGame(this);
    }

    private void precessButton(View view, Button button) {
        // Checking is this the last question
        if (questionIndex > questions.size() - 2) {
            checkAnswer(button);
            sharedViewModel.setCorrectAnswers(correctAnswersCounter);
            sharedViewModel.setIncorrectAnswers(incorrectAnswersCounter);
            Navigation.findNavController(view)
                    .navigate(R.id.action_gameFragment_to_gameResultFragment);
        } else {
            checkAnswer(button);
            Handler handler = new Handler();
            handler.postDelayed(() -> {
                questionIndex++;
                setQuestion();
                binding.invalidateAll();
            }, DELAY);
        }
    }

    private void checkAnswer(Button button) {
        if (answers.get(answerIndex).equals(correctAnswer)) {
            button.setBackgroundColor(getResources().getColor(R.color.correctAnswer));
            Handler handler = new Handler();
            handler.postDelayed(() -> button.setBackgroundColor(getResources().getColor(R.color.colorSecondaryDark)), DELAY);
            correctAnswersCounter++;
        } else {
            button.setBackgroundColor(getResources().getColor(R.color.incorrectAnswer));
            Handler handler = new Handler();
            handler.postDelayed(() -> button.setBackgroundColor(getResources().getColor(R.color.colorSecondaryDark)), DELAY);
            incorrectAnswersCounter++;
        }
    }

    private void randomizeQuestions() {
        Collections.shuffle(questions);
        setQuestion();
    }

    private void setQuestion() {
        currentQuestion = new ImageQuestion(questions.get(questionIndex).getText(), questions.get(questionIndex).getAnswers(),
                questions.get(questionIndex).getDrawableID());
        binding.questionImage.setImageResource(currentQuestion.getDrawableID());
        correctAnswer = currentQuestion.getAnswers().get(0);
        answers = questions.get(questionIndex).getAnswers();
        Collections.shuffle(answers);
    }

    private List<ImageQuestion> parseQuestionsFromTxt(String fileName) throws IOException, URISyntaxException {
        String str;
        List<ImageQuestion> questionsBank = new ArrayList<>();
        try {
            InputStream inputStream = getContext().getAssets().open(fileName);
            int size = inputStream.available();
            byte[] buffer = new byte[size];
            inputStream.read(buffer);
            str = new String(buffer);
            String[] splitRow = str.split("\n");
            String questionName;
            String questionAnswers;
            String questionImageName;
            for (int i = 0; i < splitRow.length; i++) {
                String[] splitQuestions = splitRow[i].split("\n");
                for (int j = 0; j < splitQuestions.length; j++) {
                    String[] splitQuestion = splitQuestions[j].split(":");
                    questionName = splitQuestion[0];
                    questionAnswers = splitQuestion[1];
                    questionImageName = splitQuestion[2].trim();
                    int imageID = getResources().getIdentifier(questionImageName, "drawable", getContext().getPackageName());
                    System.out.println(imageID);
                    String[] answers = questionAnswers.split(";");
                    ImageQuestion question = new ImageQuestion(questionName, Arrays.asList(answers), imageID);
                    questionsBank.add(question);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return questionsBank;
    }

    private List<ImageQuestion> getQuizTheme() throws IOException, URISyntaxException {
        if (themeIDSender.getThemeID() == 1) {
            return parseQuestionsFromTxt("geographical_quiz_questions");
        } else if (themeIDSender.getThemeID() == 0) {
            return parseQuestionsFromTxt("android_quiz_questions");
        } else if (themeIDSender.getThemeID() == 2) {
            return parseQuestionsFromTxt("car_brand_questions");
        } else if (themeIDSender.getThemeID() == 3) {
            return parseQuestionsFromTxt("science_questions");
        }
        return null;
    }
}