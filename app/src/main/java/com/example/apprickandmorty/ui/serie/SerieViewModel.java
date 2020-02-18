package com.example.apprickandmorty.ui.serie;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class SerieViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public SerieViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is serie fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}