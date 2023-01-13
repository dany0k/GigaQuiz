package ru.vsu.cs.zmaev;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import ru.vsu.cs.zmaev.databinding.FragmentTitleBinding;
import ru.vsu.cs.zmaev.model.ThemeIDSender;

public class TitleFragment extends Fragment {

    public ThemeIDSender themeIDSender;
    int themeID = -1;

    public TitleFragment() {
        super(R.layout.fragment_title);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        themeIDSender = new ViewModelProvider(getActivity()).get(ThemeIDSender.class);
        FragmentTitleBinding binding = DataBindingUtil.inflate(
                inflater, R.layout.fragment_title, container, false);
        binding.playButton.setOnClickListener(view -> {
            themeID = 0;
            themeIDSender.setThemeID(themeID);
            Navigation.findNavController(view).navigate(R.id.action_titleFragment_to_gameFragment);
        });
        binding.playGeographicalGame.setOnClickListener(v -> {
            themeID = 1;
            themeIDSender.setThemeID(themeID);
            Navigation.findNavController(v).navigate(R.id.action_titleFragment_to_gameFragment);
        });

        return binding.getRoot();
    }
}