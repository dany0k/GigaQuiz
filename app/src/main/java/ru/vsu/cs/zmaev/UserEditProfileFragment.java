package ru.vsu.cs.zmaev;

import android.os.Bundle;

import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.Arrays;

import ru.vsu.cs.zmaev.databinding.FragmentUserEditProfileBinding;
import ru.vsu.cs.zmaev.tools.DataBaseHelper;
import ru.vsu.cs.zmaev.model.User;


public class UserEditProfileFragment extends Fragment {

    public UserEditProfileFragment() {
        super(R.layout.fragment_user_edit_profile);
    }

    FragmentUserEditProfileBinding binding;


    @Override
    public View onCreateView(LayoutInflater inflater,
                             ViewGroup container,
                             Bundle savedInstanceState) {
        binding = DataBindingUtil.inflate(
                inflater, R.layout.fragment_user_edit_profile, container, false);
        DataBaseHelper dataBaseHelper = new DataBaseHelper((MainActivity) getActivity());
        // If user not exist create new one and add to db
        if (dataBaseHelper.isUserExists()) {
            ((MainActivity) getActivity()).setDrawerLocked();
            binding.submitButton.setOnClickListener(v -> {
                User newUser = new User();
                validateUser(newUser);
                boolean isInserted = dataBaseHelper.insertUser(newUser);
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
        loadUserInf(dataBaseHelper);
        binding.submitButton.setOnClickListener(v -> {
            User newUser = new User();
            validateUser(newUser);
            dataBaseHelper.updateUser(newUser);
            Navigation.findNavController(v).navigate(R.id.action_userEditProfileFragment_to_userProfileFragment);
        });

        return binding.getRoot();
    }

    private void loadUserInf(DataBaseHelper dataBaseHelper) {
        String[] userInf = dataBaseHelper.selectUser();
        binding.editName.setText(userInf[0]);
        binding.countrySpinner.setSelection(Integer.parseInt(userInf[1]));
        binding.sexSpinner.setSelection(Arrays.asList(
                getResources().getStringArray(R.array.sex)).indexOf(userInf[2]));
        binding.ageSpinner.setSelection(Arrays.asList(
                getResources().getStringArray(R.array.age)).indexOf(userInf[3]));
    }

    private void validateUser(User user) {
        user.setName(binding.editName.getText().toString());
        user.setCountryID(binding.countrySpinner.getSelectedItemPosition());
        user.setAge(Integer.parseInt(binding.ageSpinner.getSelectedItem().toString()));
        user.setSex(binding.sexSpinner.getSelectedItem().toString());
    }
}