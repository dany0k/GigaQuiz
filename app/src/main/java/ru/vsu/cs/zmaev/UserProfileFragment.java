package ru.vsu.cs.zmaev;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;

import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import ru.vsu.cs.zmaev.databinding.FragmentUserProfileBinding;
import ru.vsu.cs.zmaev.tools.DataBaseTools;

public class UserProfileFragment extends Fragment {

    public UserProfileFragment() {
        super(R.layout.fragment_user_profile);
    }

    FragmentUserProfileBinding binding;

    public String res;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_user_profile, container, false);
        binding.setUser(this);
        SQLiteDatabase db = DataBaseTools.openDataBase(getContext());
        showProfile(db);
        showResults(db);
        binding.editProfileButton.setOnClickListener(v -> {
            Navigation.findNavController(v).navigate(R.id.action_userProfileFragment_to_userEditProfileFragment);
        });
        return binding.getRoot();
    }

    private String showResults(SQLiteDatabase db) {
        Cursor query = db.rawQuery("SELECT topic_name, percentage FROM topic INNER JOIN result ON topic.topic_id == result.topic_id;", null);
        StringBuilder stringBuilder = new StringBuilder();
        while (query.moveToNext()) {
            stringBuilder.append(query.getString(0) + ": " + query.getString(1) + "\n");
        }
        return stringBuilder.toString();
    }

    private void showProfile(SQLiteDatabase db) {
        Cursor query = db.rawQuery("SELECT * FROM user;", null);
        if (query.moveToFirst()) {
            binding.profileUsername.setText(query.getString(4));
        }
        binding.result.setText(showResults(db));
        query = db.rawQuery("SELECT country_icon_name FROM country INNER JOIN user ON country.country_id == user.country_id", null);
        if (query.moveToFirst()) {
            int countryIconID = getResources().getIdentifier(query.getString(0), "drawable", getActivity().getPackageName());
            binding.countryIcon.setImageResource(countryIconID);

        }
    }
}