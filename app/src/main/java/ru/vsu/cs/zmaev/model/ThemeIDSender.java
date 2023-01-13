package ru.vsu.cs.zmaev.model;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class ThemeIDSender extends ViewModel {
    private final MutableLiveData<Integer> _themeID = new MutableLiveData<>();
    LiveData<Integer> themeID = _themeID;

    public void setThemeID(Integer themeID) {
        _themeID.setValue(themeID);
    }

    public int getThemeID() throws NullPointerException {
        return themeID.getValue();
    }
}
