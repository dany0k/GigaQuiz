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

import java.util.Collections;
import java.util.List;

import ru.vsu.cs.zmaev.databinding.FragmentGameBinding;
import ru.vsu.cs.zmaev.model.AnswersViewModel;
import ru.vsu.cs.zmaev.model.ImageQuestion;
import ru.vsu.cs.zmaev.model.QuestionBankSender;

public class GameFragment extends Fragment {

    private static final int DELAY = 500;

    FragmentGameBinding binding = null;

    public AnswersViewModel sharedViewModel;
    private QuestionBankSender questionBankSender;
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
        questionBankSender = new ViewModelProvider(getActivity()).get(QuestionBankSender.class);
        questions = questionBankSender.getTopicQuestion();

        randomizeQuestions();
        binding.setGame(GameFragment.this);
        binding.firstAnswerButton.setOnClickListener(v -> {
            answerIndex = 0;
            precessButton(v, binding.firstAnswerButton);
        });
        binding.secondAnswerButton.setOnClickListener(v -> {
            answerIndex = 1;
            precessButton(v, binding.secondAnswerButton);
        });
        binding.thirdAnswerButton.setOnClickListener(v -> {
            answerIndex = 2;
            precessButton(v, binding.thirdAnswerButton);
        });
        binding.fourthAnswerButton.setOnClickListener(v -> {
            answerIndex = 3;
            precessButton(v, binding.fourthAnswerButton);
        });

        return binding.getRoot();
    }

    @Override
    public void onDestroyView() {
        ((MainActivity) getActivity()).setDrawerUnlocked();
        super.onDestroyView();
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
}