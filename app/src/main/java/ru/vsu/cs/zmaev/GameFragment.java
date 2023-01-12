package ru.vsu.cs.zmaev;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.Navigation;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import ru.vsu.cs.zmaev.databinding.FragmentGameBinding;
import ru.vsu.cs.zmaev.model.AnswersViewModel;

public class GameFragment extends Fragment {

    public AnswersViewModel sharedViewModel;
    public GameFragment() {
        super(R.layout.fragment_game);
    }

    List<Question> questions = Arrays.asList(
            new Question("Что такое Android Jetpack?",
                    new ArrayList<>(Arrays.asList(
                            "Все из перечисленного", "Tools", "Documentation", "Libraries")
                    )),
            new Question("Что является базовым классом для layout?",
                    new ArrayList<>(Arrays.asList(
                            "ViewGroup", "ViewSet", "ViewCollection", "ViewRoot")
                    )),
            new Question("Что используется для добавления структурированных данных в layout?",
                    new ArrayList<>(Arrays.asList(
                            "Data binding", "Data pushing", "Set text", "An OnClick method")
                    ))
    );

    public Question currentQuestion;
    public String correctAnswer;
    public List<String> answers;
    public int questionIndex = 0;
    public float questionNum = Math.min((questions.size() + 1) / 2, 3);

    private int correctAnswersCounter = 0;
    private int incorrectAnswersCounter = 0;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        FragmentGameBinding binding = DataBindingUtil.inflate(inflater, R.layout.fragment_game, container, false);
        sharedViewModel = new ViewModelProvider(getActivity()).get(AnswersViewModel.class);
        randomizeQuestions();
        binding.setGame(GameFragment.this);
        binding.submitButton.setOnClickListener(view -> {
            int checkedId = binding.questionRadioGroup.getCheckedRadioButtonId();
            if (-1 != checkedId) {
                int answerIndex = 0;
                switch (checkedId) {
                    case (R.id.secondAnswerRadioButton):
                        answerIndex = 1;
                        break;
                    case (R.id.thirdAnswerRadioButton):
                        answerIndex = 2;
                        break;
                    case (R.id.fourthAnswerRadioButton):
                        answerIndex = 3;
                        break;
                }
                if (answers.get(answerIndex).equals(correctAnswer)) {
                    correctAnswersCounter++;
                } else {
                    incorrectAnswersCounter++;
                }
                if (questionIndex < questionNum) {
                    questionIndex++;
                    currentQuestion = questions.get(questionIndex);
                    setQuestion();
                    binding.invalidateAll();
                } else {
                    sharedViewModel.setCorrectAnswers(correctAnswersCounter);
                    sharedViewModel.setIncorrectAnswers(incorrectAnswersCounter);
                    Navigation.findNavController(view)
                            .navigate(R.id.action_gameFragment_to_gameResultFragment);
                }
            }
        });
        return binding.getRoot();
    }

    private void randomizeQuestions() {
        Collections.shuffle(questions);
        questionIndex = 0;
        setQuestion();
    }

    private void setQuestion() {
        currentQuestion = questions.get(questionIndex);
        correctAnswer = currentQuestion.getAnswers().get(0);
        answers = questions.get(questionIndex).getAnswers();
        Collections.shuffle(answers);
    }
}