package ru.vsu.cs.zmaev;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Date;
import java.util.List;

import ru.vsu.cs.zmaev.databinding.FragmentGameBinding;

public class GameFragment extends Fragment {
    public GameFragment() {
        super(R.layout.fragment_game);
    }

    List<Question> questions = Arrays.asList(
            new Question("What is Android Jetpack?",
                    new ArrayList<>(Arrays.asList(
                            "All of these", "Tools", "Documentation", "Libraries")
                    )),
            new Question("What is the base class for layouts?",
                    new ArrayList<>(Arrays.asList(
                            "ViewGroup", "ViewSet", "ViewCollection", "ViewRoot")
                    )),
            new Question("What do you use to push structured data into a layout?",
                    new ArrayList<>(Arrays.asList(
                            "Data binding", "Data pushing", "Set text", "An OnClick method")
                    ))
    );

    public Question currentQuestion;
    public String correctAnswer;
    public List<String> answers;
    public int questionIndex = 0;
    public float questionNum = Math.min((questions.size() + 1) / 2, 3);



    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        FragmentGameBinding binding = DataBindingUtil.inflate(inflater, R.layout.fragment_game, container, false);
        randomizeQuestions();
        binding.setGame(this);
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
                    questionIndex++;

                    if (questionIndex <= questionNum) {
                        currentQuestion = questions.get(questionIndex);
                        setQuestion();
                        binding.invalidateAll();
                    } else {
                        Toast.makeText(getContext(), "Разъебал", Toast.LENGTH_LONG).show();
                        // TODO: Navigation
                    }
                } else {
                    Toast.makeText(getContext(), "Проебал", Toast.LENGTH_LONG).show();
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