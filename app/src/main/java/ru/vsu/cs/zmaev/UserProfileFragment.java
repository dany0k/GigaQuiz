package ru.vsu.cs.zmaev;

import android.annotation.SuppressLint;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.drawable.Drawable;
import android.os.Bundle;

import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationConfig;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.HashMap;
import java.util.Map;

import ru.vsu.cs.zmaev.databinding.FragmentUserProfileBinding;
import ru.vsu.cs.zmaev.model.User;
import ru.vsu.cs.zmaev.tools.DataBaseTools;

public class UserProfileFragment extends Fragment {

    public UserProfileFragment() {
        super(R.layout.fragment_user_profile);
    }

    FragmentUserProfileBinding binding;

    public String androidResult;
    public String geographicalResult;
    public Drawable countryIcon;
    public String res;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_user_profile, container, false);
        binding.setUser(this);
//        try {
//            ObjectMapper objectMapper = new ObjectMapper();
//            user = objectMapper.readValue(userStr, User.class);
//        } catch (JsonProcessingException e) {
//            e.printStackTrace();
//        }
        showProfile();
        binding.editProfileButton.setOnClickListener(v -> {
            Navigation.findNavController(v).navigate(R.id.action_userProfileFragment_to_userEditProfileFragment);
        });
        return binding.getRoot();
    }

    private void showProfile() {
        SQLiteDatabase db = DataBaseTools.openDataBase(getContext());
        Cursor query = db.rawQuery("SELECT * FROM user;", null);
        if (query.moveToFirst()) {
            System.out.println("\n\n\n"+query.getString(0));
            System.out.println("\n\n\n"+query.getString(1));
            System.out.println("\n\n\n"+query.getString(2));
            System.out.println("\n\n\n"+query.getString(3));
            System.out.println("\n\n\n"+query.getString(4));
            System.out.println("\n\n\n"+query.getString(5));
            System.out.println("\n\n\n"+query.getString(6));
            binding.profileUsername.setText(query.getString(4));
        }

//        binding.result.setText(setUserResult(user));
//        setUserFlag(user);
    }
}
//    private String setUserResult(User user) {
//        String[] topics = user.getTopics()
//                .replace("[", "").replace("]", "")
//                .replaceAll("\\\\", "").replaceAll("\"", "")
//                .split(",");
//        int[] results = JSONTools.fromString(user.getResults());
//        StringBuilder stringBuilder = new StringBuilder();
//        for (int i = 0; i < results.length; i++) {
//            for (int j = 0; j < 1; j++) {
//                stringBuilder.append(topics[i] + ": " + results[i] + "%");
//            }
//            stringBuilder.append("\n");
//        }
//        return stringBuilder.toString();
//    }

//    @SuppressLint("UseCompatLoadingForDrawables")
//    private void setUserFlag(User user) {
//        switch (user.getCountry()) {
//            case "Армения":
//                countryIcon = getResources().getDrawable(R.drawable.armenia);
//                break;
//            case "Азербайджан":
//                countryIcon = getResources().getDrawable(R.drawable.azerbaijan);
//                break;
//            case "Беларусь":
//                countryIcon = getResources().getDrawable(R.drawable.belarus);
//                break;
//            case "Грузия":
//                countryIcon = getResources().getDrawable(R.drawable.georgia);
//                break;
//            case "Казахстан":
//                countryIcon = getResources().getDrawable(R.drawable.kazakhstan);
//                break;
//            case "Кыргызстан":
//                countryIcon = getResources().getDrawable(R.drawable.kyrgyzstan);
//                break;
//            case "Молдова":
//                countryIcon = getResources().getDrawable(R.drawable.moldova);
//                break;
//            case "Россия":
//                countryIcon = getResources().getDrawable(R.drawable.russia);
//                break;
//            case "Таджикистан":
//                countryIcon = getResources().getDrawable(R.drawable.tajikistan);
//                break;
//            case "Туркменистан":
//                countryIcon = getResources().getDrawable(R.drawable.turkmenistan);
//                break;
//            case "Украина":
//                countryIcon = getResources().getDrawable(R.drawable.ukraine);
//                break;
//            case "Узбекистан":
//                countryIcon = getResources().getDrawable(R.drawable.uzbekistan);
//                break;
//            default:
//                countryIcon = getResources().getDrawable(R.drawable.earth);
//                break;
//        }
//    }
