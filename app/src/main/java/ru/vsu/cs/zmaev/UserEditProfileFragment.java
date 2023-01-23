package ru.vsu.cs.zmaev;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;

import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;

import java.sql.Connection;
import java.util.Arrays;
import java.util.List;

import ru.vsu.cs.zmaev.databinding.FragmentUserEditProfileBinding;
import ru.vsu.cs.zmaev.tools.DataBaseTools;
import ru.vsu.cs.zmaev.model.User;


public class UserEditProfileFragment extends Fragment {

    public UserEditProfileFragment() {
        super(R.layout.fragment_user_edit_profile);
    }

    FragmentUserEditProfileBinding binding;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_user_edit_profile, container, false);

        SQLiteDatabase db = DataBaseTools.openDataBase(getContext());
        // If user not exist create new one and add to db
        Cursor query = db.rawQuery("SELECT * FROM user;", null);
        if (!query.moveToFirst()) {
            ((MainActivity) getActivity()).setDrawerLocked();
            binding.submitButton.setOnClickListener(v -> {
                User newUser = new User();
                validateUser(newUser);
                boolean isInserted = DataBaseTools.insertUser(db, newUser);
                if (isInserted) {
                    System.out.println("DATA INSERTED");
                } else {
                    System.out.println("ERROR");
                }
                ((MainActivity) getActivity()).setDrawerUnlocked();
                Navigation.findNavController(v).navigate(R.id.action_userEditProfileFragment_to_titleFragment);
            });
            return binding.getRoot();
        }
        loadUserInf();
        binding.submitButton.setOnClickListener(v -> {
            User newUser = new User();
            validateUser(newUser);
            DataBaseTools.updateUser(db, newUser);
            Navigation.findNavController(v).navigate(R.id.action_userEditProfileFragment_to_userProfileFragment);
        });

        return binding.getRoot();
    }

    private void loadUserInf() {
        SQLiteDatabase db = DataBaseTools.openDataBase(getContext());
        Cursor query = db.rawQuery("SELECT * FROM user;", null);
        if (query.moveToFirst()) {
            binding.editName.setText(query.getString(4));
            binding.countrySpinner.setSelection(Integer.parseInt(query.getString(1)));
            binding.sexSpinner.setSelection(Arrays.asList(getResources().getStringArray(R.array.sex)).indexOf(query.getString(6)));
            binding.ageSpinner.setSelection(Arrays.asList(getResources().getStringArray(R.array.age)).indexOf(query.getString(5)));
        }
    }

    private void validateUser(User user) {
        user.setName(binding.editName.getText().toString());
        user.setCountryID(binding.countrySpinner.getSelectedItemPosition());
        user.setAge(Integer.parseInt(binding.ageSpinner.getSelectedItem().toString()));
        user.setSex(binding.sexSpinner.getSelectedItem().toString());
    }
}