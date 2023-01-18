package ru.vsu.cs.zmaev;

import android.annotation.SuppressLint;
import android.graphics.drawable.Drawable;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import ru.vsu.cs.zmaev.databinding.FragmentUserProfileBinding;
import ru.vsu.cs.zmaev.model.JsonAdapter;
import ru.vsu.cs.zmaev.model.User;

public class UserProfileFragment extends Fragment {

    public UserProfileFragment() {
        super(R.layout.fragment_user_profile);
    }

    FragmentUserProfileBinding binding;

    public String androidResult;
    public String geographicalResult;
    public Drawable countryIcon;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_user_profile, container, false);
        binding.setUser(this);
        String userStr = JsonAdapter.readJsonFile(getContext(), "user.json");
        User user = new User();
        try {
            user = new ObjectMapper().readValue(userStr, User.class);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        showProfile(user);
        binding.editProfileButton.setOnClickListener(v -> {
            Navigation.findNavController(v).navigate(R.id.action_userProfileFragment_to_userEditProfileFragment);
        });
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {

        super.onViewCreated(view, savedInstanceState);
    }

    private void showProfile(User user) {
        binding.profileUsername.setText(user.getName());
        androidResult = getResources().getString(R.string.android_result) + " " + user.getAndroidResult() + "%";
        geographicalResult = getResources().getString(R.string.geographical_result) + " " + user.getGeographicalResult() + "%";
        setUserFlag(user);
    }

    @SuppressLint("UseCompatLoadingForDrawables")
    private void setUserFlag(User user) {
        switch (user.getCountry()) {
            case "Армения":
                countryIcon = getResources().getDrawable(R.drawable.armenia);
                break;
            case "Азербайджан":
                countryIcon = getResources().getDrawable(R.drawable.azerbaijan);
                break;
            case "Беларусь":
                countryIcon = getResources().getDrawable(R.drawable.belarus);
                break;
            case "Грузия":
                countryIcon = getResources().getDrawable(R.drawable.georgia);
                break;
            case "Казахстан":
                countryIcon = getResources().getDrawable(R.drawable.kazakhstan);
                break;
            case "Кыргызстан":
                countryIcon = getResources().getDrawable(R.drawable.kyrgyzstan);
                break;
            case "Молдова":
                countryIcon = getResources().getDrawable(R.drawable.moldova);
                break;
            case "Россия":
                countryIcon = getResources().getDrawable(R.drawable.russia);
                break;
            case "Таджикистан":
                countryIcon = getResources().getDrawable(R.drawable.tajikistan);
                break;
            case "Туркменистан":
                countryIcon = getResources().getDrawable(R.drawable.turkmenistan);
                break;
            case "Украина":
                countryIcon = getResources().getDrawable(R.drawable.ukraine);
                break;
            case "Узбекистан":
                countryIcon = getResources().getDrawable(R.drawable.uzbekistan);
                break;

        }
    }
}