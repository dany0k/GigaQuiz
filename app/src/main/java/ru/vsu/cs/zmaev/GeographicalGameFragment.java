package ru.vsu.cs.zmaev;

import android.graphics.BitmapFactory;
import android.graphics.drawable.Drawable;
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
import java.util.Objects;

import ru.vsu.cs.zmaev.databinding.FragmentGeographicalGameBinding;
import ru.vsu.cs.zmaev.model.AnswersViewModel;

public class GeographicalGameFragment extends Fragment {

    FragmentGeographicalGameBinding binding = null;

    public AnswersViewModel sharedViewModel;
    public GeographicalGameFragment() {
        super(R.layout.fragment_geographical_game);
    }

    List<ImageQuestion> questions = Arrays.asList(
            new ImageQuestion("Какое самое глубокое озеро в мире?",
                    new ArrayList<>(Arrays.asList(
                            "Байкал", "Каспийское море", "Виктория", "Мичиган")
                    ),
                    R.drawable.earth),
            new ImageQuestion("Столица Албании?",
                    new ArrayList<>(Arrays.asList(
                            "Тирана", "София", "Загреб", "Братислава")
                    ),
                    R.drawable.earth),
            new ImageQuestion("Какой стране принадлежит этот флаг?",
                    new ArrayList<>(Arrays.asList(
                            "Аргентина", "Бельгия", "Уругвай", "Либерия")
                    ),
                    R.drawable.argentina_flag),
            new ImageQuestion("Какая самая высокая гора в Европе?",
                    new ArrayList<>(Arrays.asList(
                            "Эльбрус", "Эверест", "Шхара", "Монбланч")
                    ),
                    R.drawable.mountain),
            new ImageQuestion("Какой самый крупный город по населению Европе?",
                    new ArrayList<>(Arrays.asList(
                            "Стамбул", "Лондон", "Москва", "Париж")
                    ),
                    R.drawable.city),
            new ImageQuestion("Какой стране принадлежит этот флаг?",
                    new ArrayList<>(Arrays.asList(
                            "Аргентина", "Бельгия", "Уругвай", "Либерия")
                    ),
                    R.drawable.argentina_flag),
            new ImageQuestion("Какой стране является третьей по площади в мире?",
                    new ArrayList<>(Arrays.asList(
                            "США", "Китай", "Канада", "Бразилия")
                    ),
                    R.drawable.earth),
            new ImageQuestion("Какая страна изображена на силуете?",
                    new ArrayList<>(Arrays.asList(
                            "Австрия", "Словения", "Бельгия", "Болгария")
                    ),
                    R.drawable.austria),
            new ImageQuestion("Какая страна является самой малой по площади в Южной Америке?",
                    new ArrayList<>(Arrays.asList(
                            "Суринам", "Гайана", "Французская Гвиана", "Уругвай")
                    ),
                    R.drawable.earth),
            new ImageQuestion("Какая страна является бывшей колонией Португалии в Китае?",
                    new ArrayList<>(Arrays.asList(
                            "Макао", "Гонконг", "Тайвань", "Тибет")
                    ),
                    R.drawable.earth)
    );

    public ImageQuestion currentQuestion;
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
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_geographical_game, container, false);
        sharedViewModel = new ViewModelProvider(getActivity()).get(AnswersViewModel.class);
        randomizeQuestions();
        binding.setGame(GeographicalGameFragment.this);
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
                if (questionIndex < questions.size() - 1) {
                    questionIndex++;
                    currentQuestion = questions.get(questionIndex);
                    setQuestion();
                    binding.invalidateAll();
                } else {
                    sharedViewModel.setCorrectAnswers(correctAnswersCounter);
                    sharedViewModel.setIncorrectAnswers(incorrectAnswersCounter);
                    Navigation.findNavController(view)
                            .navigate(R.id.action_geographicalGameFragment_to_gameResultFragment);
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
        binding.questionImage.setImageResource(currentQuestion.getDrawable_id());
        correctAnswer = currentQuestion.getAnswers().get(0);
        answers = questions.get(questionIndex).getAnswers();
        Collections.shuffle(answers);
    }
}