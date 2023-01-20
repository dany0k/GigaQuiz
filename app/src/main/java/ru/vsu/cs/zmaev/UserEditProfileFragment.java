package ru.vsu.cs.zmaev;

import android.os.Bundle;

import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.Arrays;

import ru.vsu.cs.zmaev.databinding.FragmentUserEditProfileBinding;
import ru.vsu.cs.zmaev.tools.FileTools;
import ru.vsu.cs.zmaev.tools.JSONTools;
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

        if (!FileTools.isFilePresent(getContext(), "user.json")) {
            ((MainActivity) getActivity()).setDrawerLocked();
            binding.submitButton.setOnClickListener(v -> {
                User newUser = new User();
                validateUser(newUser);
                JSONTools.createJsonFile(getContext(), "user.json", newUser.toJson().toString());
                ((MainActivity) getActivity()).setDrawerUnlocked();
                Navigation.findNavController(v).navigate(R.id.action_userEditProfileFragment_to_titleFragment);
            });
            return binding.getRoot();
        }

        String userStr = JSONTools.readJsonFile(getContext(), "user.json");
        User user = new User();
        try {
            user = new ObjectMapper().readValue(userStr, User.class);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        loadUserInf(user);
        binding.submitButton.setOnClickListener(v -> {
            User newUser = new User();
            try {
                newUser = new ObjectMapper().readValue(userStr, User.class);
            } catch (JsonProcessingException e) {
                e.printStackTrace();
            }
            validateUser(newUser);
            JSONTools.createJsonFile(getContext(), "user.json", newUser.toJson().toString());
            System.out.println(newUser);
            Navigation.findNavController(v).navigate(R.id.action_userEditProfileFragment_to_userProfileFragment);
        });

        return binding.getRoot();
    }

    private void loadUserInf(User user) {
        binding.editName.setText(user.getName());
        binding.countrySpinner.setSelection(Arrays.asList(getResources().getStringArray(R.array.countriesNames)).indexOf(user.getCountry()));
        binding.ageSpinner.setSelection(Arrays.asList(getResources().getStringArray(R.array.age)).indexOf(Integer.toString(user.getAge())));
        binding.sexSpinner.setSelection(Arrays.asList(getResources().getStringArray(R.array.sex)).indexOf(user.getSex()));
    }


    private void validateUser(User user) {
        user.setName(binding.editName.getText().toString());
        user.setCountry(binding.countrySpinner.getSelectedItem().toString());
        user.setAge(Integer.parseInt(binding.ageSpinner.getSelectedItem().toString()));
        user.setSex(binding.sexSpinner.getSelectedItem().toString());
    }
}