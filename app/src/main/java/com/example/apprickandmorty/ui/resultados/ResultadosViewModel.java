package com.example.apprickandmorty.ui.resultados;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class ResultadosViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public ResultadosViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is resultados fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}