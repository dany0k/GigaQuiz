package ru.vsu.cs.zmaev;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import ru.vsu.cs.zmaev.databinding.FragmentGameOverBinding;

public class GameOverFragment extends Fragment {
    public GameOverFragment() {
        super(R.layout.fragment_game_over);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        FragmentGameOverBinding binding = DataBindingUtil.inflate(
                inflater, R.layout.fragment_game_over, container, false);
        binding.tryAgainButton.setOnClickListener(view -> Navigation.findNavController(view).navigate(R.id.action_gameOverFragment_to_gameFragment));
        return binding.getRoot();
    }
}