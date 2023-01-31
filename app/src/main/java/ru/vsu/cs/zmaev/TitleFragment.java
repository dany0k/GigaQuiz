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
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import java.util.List;

import ru.vsu.cs.zmaev.databinding.FragmentTitleBinding;
import ru.vsu.cs.zmaev.model.ImageQuestion;
import ru.vsu.cs.zmaev.tools.DataBaseHelper;
import ru.vsu.cs.zmaev.model.QuestionBankSender;

public class TitleFragment extends Fragment {

    FragmentTitleBinding binding;

    public QuestionBankSender questionBankSender;

    public TitleFragment() {
        super(R.layout.fragment_title);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        questionBankSender = new ViewModelProvider(getActivity()).get(QuestionBankSender.class);
        binding = DataBindingUtil.inflate(
                inflater, R.layout.fragment_title, container, false);
        DataBaseHelper dataBaseHelper = new DataBaseHelper((MainActivity) getActivity());
        Spinner topicSpinner = binding.topicsSpinner;
        String[] topics = dataBaseHelper.getTopics();
        ArrayAdapter<String> adapter =
                new ArrayAdapter(getActivity(), android.R.layout.simple_spinner_item, topics);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        topicSpinner.setAdapter(adapter);
        // If user not exists register new one
        if (dataBaseHelper.isUserExists()) {
            binding.themeTextView.setVisibility(View.GONE);
            binding.topicsSpinner.setVisibility(View.GONE);
            binding.playButton.setVisibility(View.GONE);
            binding.registrationButton.setVisibility(View.VISIBLE);
            binding.registrationButton.setOnClickListener(view -> {
                Navigation.findNavController(view)
                        .navigate(R.id.action_titleFragment_to_userEditProfileFragment);
            });
        } else {
            binding.playButton.setOnClickListener(v -> {
                int topicID = binding.topicsSpinner.getSelectedItemPosition() + 1;
                List<ImageQuestion> questionsBank =
                        dataBaseHelper.getQuestionsBank(((MainActivity) getActivity()), topicID);
                questionBankSender.setTopicQuestions(questionsBank);
                questionBankSender.setTopicID(topicID);
                Navigation.findNavController(v).navigate(R.id.action_titleFragment_to_gameFragment);
            });
        }
        return binding.getRoot();
    }
}