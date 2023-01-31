package ru.vsu.cs.zmaev;

import android.os.Bundle;

import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import ru.vsu.cs.zmaev.databinding.FragmentUserProfileBinding;
import ru.vsu.cs.zmaev.tools.DataBaseHelper;

public class UserProfileFragment extends Fragment {

    FragmentUserProfileBinding binding;

    public String res;

    public UserProfileFragment() {
        super(R.layout.fragment_user_profile);
    }

    @Override
    public View onCreateView(LayoutInflater inflater,
                             ViewGroup container,
                             Bundle savedInstanceState) {
        binding = DataBindingUtil.inflate(
                inflater, R.layout.fragment_user_profile, container, false);
        binding.setUser(this);
        DataBaseHelper dataBaseHelper = new DataBaseHelper((MainActivity) getActivity());
        dataBaseHelper.showProfile((MainActivity) (getActivity()),
                binding.profileUsername,
                binding.result,
                binding.countryIcon);
        binding.editProfileButton.setOnClickListener(v -> {
            Navigation.findNavController(v).navigate(R.id.action_userProfileFragment_to_userEditProfileFragment);
        });
        return binding.getRoot();
    }
}