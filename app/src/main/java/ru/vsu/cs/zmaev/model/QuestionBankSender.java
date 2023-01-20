package ru.vsu.cs.zmaev.model;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import java.util.List;

public class QuestionBankSender extends ViewModel {
    private final MutableLiveData<List<ImageQuestion>> _themeID = new MutableLiveData<>();
    LiveData<List<ImageQuestion>> themeID = _themeID;

    public void setTopicQuestions(List<ImageQuestion> themeID) {
        _themeID.setValue(themeID);
    }

    public List<ImageQuestion> getTopicQuestion() throws NullPointerException {
        return themeID.getValue();
    }
}
