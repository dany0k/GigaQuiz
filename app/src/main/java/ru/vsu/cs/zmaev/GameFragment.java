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

import ru.vsu.cs.zmaev.databinding.FragmentGameBinding;
import ru.vsu.cs.zmaev.model.AnswersViewModel;
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
        questions = getQuizTheme();
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
                questions.get(questionIndex).getDrawable_id());
        binding.questionImage.setImageResource(currentQuestion.getDrawable_id());
        correctAnswer = currentQuestion.getAnswers().get(0);
        answers = questions.get(questionIndex).getAnswers();
        Collections.shuffle(answers);
    }

    private List<ImageQuestion> getQuizTheme() {
        if (themeIDSender.getThemeID() == 1) {
            return Arrays.asList(
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
        } else if (themeIDSender.getThemeID() == 0) {
            return Arrays.asList(
                    new ImageQuestion("Что такое Android Jetpack?",
                            new ArrayList<>(Arrays.asList(
                                    "Все из перечисленного", "Tools", "Documentation", "Libraries")
                            ),
                                    R.drawable.android),
                    new ImageQuestion("Что является базовым классом для layout?",
                            new ArrayList<>(Arrays.asList(
                                    "ViewGroup", "ViewSet", "ViewCollection", "ViewRoot")
                            ),
                            R.drawable.android),
                    new ImageQuestion("Что используется для добавления структурированных данных в layout?",
                            new ArrayList<>(Arrays.asList(
                                    "Data binding", "Data pushing", "Set text", "An OnClick method")
                            ),
                            R.drawable.android),
                    new ImageQuestion("Какой layout используется для сложных экранов?",
                            new ArrayList<>(Arrays.asList(
                                    "ConstraintLayout", "GridLayout", "LinearLayout", "FrameLayout")
                            ),
                            R.drawable.android),
                    new ImageQuestion("Как называется система сборки для Android?",
                            new ArrayList<>(Arrays.asList(
                                    "Gradle", "Graddle", "Grodle", "Groyle")
                            ),
                            R.drawable.android),
                    new ImageQuestion("Какой класс используется для создания векторного рисунка?",
                            new ArrayList<>(Arrays.asList(
                                    "VectorDrawable", "AndroidVectorDrawable", "DrawableVector", "AndroidVector")
                            ),
                            R.drawable.android),
                    new ImageQuestion("Что из перечисленного является компонентом навигации Android?",
                            new ArrayList<>(Arrays.asList(
                                    "NavController", "NavCentral", "NavMaster", "NavSwitcher")
                            ),
                            R.drawable.android),
                    new ImageQuestion("Какой элемент XML позволяет зарегистрировать действие в средстве запуска?",
                            new ArrayList<>(Arrays.asList(
                                    "intent-filter", "app-registry", "launcher-registry", "app-launcher")
                            ),
                            R.drawable.android),
                    new ImageQuestion("Какой тэг используется для соединения UI приложения и бизнес-логики?",
                            new ArrayList<>(Arrays.asList(
                                    "<layout>", "<binding>", "<data-binding>", "<dbinding>")
                            ),
                            R.drawable.android),
                    new ImageQuestion("Какой метод находит объект по id?",
                            new ArrayList<>(Arrays.asList(
                                    "FindViewID", "findViewId", "findViewById", "findById")
                            ),
                            R.drawable.android)
            );
        }
        return null;
    }
}