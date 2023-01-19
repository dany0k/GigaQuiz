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
import ru.vsu.cs.zmaev.model.JsonAdapter;
import ru.vsu.cs.zmaev.model.ThemeIDSender;

public class TitleFragment extends Fragment {

    FragmentTitleBinding binding;

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
         binding = DataBindingUtil.inflate(
                inflater, R.layout.fragment_title, container, false);
         if (JsonAdapter.isFilePresent(getContext(), "user.json")) {
             showPlayButtons();
             binding.registrationButton.setVisibility(View.GONE);
             binding.playAndroidQuiz.setOnClickListener(v -> {
                 redirectToGameFragment(v, 0);
             });
             binding.playGeographicalQuiz.setOnClickListener(v -> {
                 themeID = 1;
                 themeIDSender.setThemeID(themeID);
                 Navigation.findNavController(v).navigate(R.id.action_titleFragment_to_gameFragment);
             });
             binding.playAutoBrandQuiz.setOnClickListener(v -> {
                 redirectToGameFragment(v, 2);
             });
             binding.playScienceQuiz.setOnClickListener(v -> {
                 redirectToGameFragment(v, 3);
             });
         } else {
             binding.registrationButton.setVisibility(View.VISIBLE);
             hidePlayButtons();
             binding.registrationButton.setOnClickListener(view -> {
                Navigation.findNavController(view).navigate(R.id.action_titleFragment_to_userEditProfileFragment);
             });
         }

        return binding.getRoot();
    }

    private void showPlayButtons() {
        binding.themeTextView.setVisibility(View.VISIBLE);
        binding.allThemesLinearLayout.setVisibility(View.VISIBLE);
    }

    private void hidePlayButtons() {
        binding.themeTextView.setVisibility(View.GONE);
        binding.allThemesLinearLayout.setVisibility(View.GONE);
    }

    private void redirectToGameFragment(View v, int themeID) {
        themeIDSender.setThemeID(themeID);
        Navigation.findNavController(v).navigate(R.id.action_titleFragment_to_gameFragment);
    }
}