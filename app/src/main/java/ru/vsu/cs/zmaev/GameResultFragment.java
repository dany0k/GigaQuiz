package ru.vsu.cs.zmaev;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import ru.vsu.cs.zmaev.databinding.FragmentGameResultBinding;
import ru.vsu.cs.zmaev.model.AnswersViewModel;

public class GameResultFragment extends Fragment {

    private AnswersViewModel sharedViewModel;

    int correctAnswersCounter = 0;
    int incorrectAnswersCounter = 0;

    public GameResultFragment() {
        super(R.layout.fragment_game_result);
    }

    FragmentGameResultBinding binding = null;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_game_result, container, false);
        sharedViewModel = new ViewModelProvider(getActivity()).get(AnswersViewModel.class);
        correctAnswersCounter = sharedViewModel.getCorrectAnswers();
        incorrectAnswersCounter = sharedViewModel.getIncorrectAnswers();
        System.out.printf("\n\n\nC:%s, I:%s", correctAnswersCounter, incorrectAnswersCounter);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        binding.setLifecycleOwner(getViewLifecycleOwner());
        binding.setViewModel(this);
    }

    public String sendAnswers() {
        System.out.println("\n\n\n" + correctAnswersCounter + " " + incorrectAnswersCounter);
        return "Correct answers: " + correctAnswersCounter + "\n" + "Incorrect answers: " + incorrectAnswersCounter;
    }

}