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

    private static final int FIRST_ANSWER_SELECTED = 0;
    private static final int SECOND_ANSWER_SELECTED = 1;
    private static final int THIRD_ANSWER_SELECTED = 2;
    private static final int FOURTH_ANSWER_SELECTED = 3;

    FragmentGameBinding binding = null;

    public AnswersViewModel sharedViewModel;
    private QuestionBankSender questionBankSender;

    List<ImageQuestion> questions;

    public ImageQuestion currentQuestion;
    public String correctAnswer;
    public List<String> answers;
    public int questionIndex = 0;

    private int correctAnswersCounter = 0;
    private int incorrectAnswersCounter = 0;
    private int answerIndex;

    public GameFragment() {
        super(R.layout.fragment_game);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_game, container, false);
        sharedViewModel = new ViewModelProvider(getActivity()).get(AnswersViewModel.class);
        questionBankSender = new ViewModelProvider(getActivity()).get(QuestionBankSender.class);
        questions = questionBankSender.getTopicQuestions();
        randomizeQuestions();
        binding.setGame(GameFragment.this);
        binding.firstAnswerButton.setOnClickListener(v -> {
            answerIndex = FIRST_ANSWER_SELECTED;
            precessButton(v, binding.firstAnswerButton);
        });
        binding.secondAnswerButton.setOnClickListener(v -> {
            answerIndex = SECOND_ANSWER_SELECTED;
            precessButton(v, binding.secondAnswerButton);
        });
        binding.thirdAnswerButton.setOnClickListener(v -> {
            answerIndex = THIRD_ANSWER_SELECTED;
            precessButton(v, binding.thirdAnswerButton);
        });
        binding.fourthAnswerButton.setOnClickListener(v -> {
            answerIndex = FOURTH_ANSWER_SELECTED;
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
            int topicID = questionBankSender.getTopicID();
            sharedViewModel.setTopicID(topicID);
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
            handler.postDelayed(() ->
                    button.setBackgroundColor(
                            getResources().getColor(R.color.colorSecondaryDark)), DELAY);
            correctAnswersCounter++;
        } else {
            button.setBackgroundColor(getResources().getColor(R.color.incorrectAnswer));
            Handler handler = new Handler();
            handler.postDelayed(() ->
                    button.setBackgroundColor(
                            getResources().getColor(R.color.colorSecondaryDark)), DELAY);
            incorrectAnswersCounter++;
        }
    }

    private void randomizeQuestions() {
        Collections.shuffle(questions);
        setQuestion();
    }

    private void setQuestion() {
        currentQuestion = new ImageQuestion(
                questions.get(questionIndex).getText(), questions.get(questionIndex).getAnswers(),
                questions.get(questionIndex).getDrawableID());
        binding.questionImage.setImageResource(currentQuestion.getDrawableID());
        correctAnswer = currentQuestion.getAnswers().get(0);
        answers = questions.get(questionIndex).getAnswers();
        Collections.shuffle(answers);
    }
}