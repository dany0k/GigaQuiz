package ru.vsu.cs.zmaev;

import android.os.Bundle;

import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import ru.vsu.cs.zmaev.databinding.FragmentUserEditProfileBinding;


public class UserEditProfileFragment extends Fragment {

    public UserEditProfileFragment() {
        super(R.layout.fragment_user_edit_profile);
    }


    FragmentUserEditProfileBinding binding;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_user_edit_profile, container, false);
//        Spinner spinner = binding.spinnerCountry;
//        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(getContext(), R.array.countriesNames,
//                android.R.layout.simple_spinner_item);
//        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
//        spinner.setAdapter(adapter);
        return binding.getRoot();
    }
}