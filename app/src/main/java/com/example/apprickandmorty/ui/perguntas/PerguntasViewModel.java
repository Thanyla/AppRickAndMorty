package com.example.apprickandmorty.ui.perguntas;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class PerguntasViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public PerguntasViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is perguntas fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}