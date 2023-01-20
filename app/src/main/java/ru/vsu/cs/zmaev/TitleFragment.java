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

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.List;

import ru.vsu.cs.zmaev.databinding.FragmentTitleBinding;
import ru.vsu.cs.zmaev.model.ImageQuestion;
import ru.vsu.cs.zmaev.tools.FileTools;
import ru.vsu.cs.zmaev.model.QuestionBankSender;

public class TitleFragment extends Fragment {

    FragmentTitleBinding binding;

    public QuestionBankSender questionBankSender;

    public TitleFragment() {
        super(R.layout.fragment_title);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        questionBankSender = new ViewModelProvider(getActivity()).get(QuestionBankSender.class);
        binding = DataBindingUtil.inflate(
                inflater, R.layout.fragment_title, container, false);
        List<String> quizTopics = FileTools.readFilesInList(getActivity(), "");
        if (FileTools.isFilePresent(getContext(), "user.json")) {
            binding.registrationButton.setVisibility(View.GONE);
        } else {
            binding.themeTextView.setVisibility(View.GONE);
            binding.topicsSpinner.setVisibility(View.GONE);
            binding.playButton.setVisibility(View.GONE);
            binding.registrationButton.setVisibility(View.VISIBLE);
            binding.registrationButton.setOnClickListener(view -> {
                Navigation.findNavController(view).navigate(R.id.action_titleFragment_to_userEditProfileFragment);
            });
        }
        binding.playButton.setOnClickListener(v -> {
            try {
                List<ImageQuestion> questionsBank = getQuizTheme(binding.topicsSpinner.getSelectedItemPosition(), quizTopics);
                questionBankSender.setTopicQuestions(questionsBank);
                Navigation.findNavController(v).navigate(R.id.action_titleFragment_to_gameFragment);
            } catch (IOException | URISyntaxException e) {
                e.printStackTrace();
            }
        });

        return binding.getRoot();
    }

    private List<ImageQuestion> getQuizTheme(int topicID, List<String> quizTopics) throws IOException, URISyntaxException {
        return FileTools.parseQuestionsFromTxt(getActivity(), quizTopics.get(topicID));
    }
}