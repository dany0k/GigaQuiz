package ru.vsu.cs.zmaev.model;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class AnswersViewModel extends ViewModel {

    private final MutableLiveData<Integer> _correctAnswers = new MutableLiveData<>();
    LiveData<Integer> correctAnswers = _correctAnswers;

    private final MutableLiveData<Integer> _incorrectAnswers = new MutableLiveData<>();
    LiveData<Integer> incorrectAnswers = _incorrectAnswers;

    public void setCorrectAnswers(Integer correctAnswers) {
        _correctAnswers.setValue(correctAnswers);
    }

    public void setIncorrectAnswers(Integer incorrectAnswers) {
        _incorrectAnswers.setValue(incorrectAnswers);
    }

    public int getCorrectAnswers() throws NullPointerException {
        return correctAnswers.getValue();
    }

    public int getIncorrectAnswers() throws NullPointerException {
        return incorrectAnswers.getValue();
    }
}
