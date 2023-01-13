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

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import ru.vsu.cs.zmaev.databinding.FragmentGeographicalGameBinding;
import ru.vsu.cs.zmaev.model.AnswersViewModel;

public class GeographicalGameFragment extends Fragment {

    private static final int DELAY = 500;

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
                    R.drawable.city),
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
            new ImageQuestion("Столицей какого государства является Джакарта?",
                    new ArrayList<>(Arrays.asList(
                            "Индонезия", "Австралия", "Малайзия", "Сингапур")
                    ),
                    R.drawable.city),
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

    private int correctAnswersCounter = 0;
    private int incorrectAnswersCounter = 0;
    private int answerIndex;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_geographical_game, container, false);
        sharedViewModel = new ViewModelProvider(getActivity()).get(AnswersViewModel.class);
        randomizeQuestions();
        binding.setGame(GeographicalGameFragment.this);
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

    private void precessButton(View view, Button button) {
        // Checking is this the last question
        if (questionIndex > questions.size() - 2) {
            checkAnswer(button);
            sharedViewModel.setCorrectAnswers(correctAnswersCounter);
            sharedViewModel.setIncorrectAnswers(incorrectAnswersCounter);
            Navigation.findNavController(view)
                    .navigate(R.id.action_geographicalGameFragment_to_gameResultFragment);
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
                questions.get(questionIndex).getDrawable_id());
        binding.questionImage.setImageResource(currentQuestion.getDrawable_id());
        correctAnswer = currentQuestion.getAnswers().get(0);
        answers = questions.get(questionIndex).getAnswers();
        System.out.println(currentQuestion.getText());
        Collections.shuffle(answers);
    }
}