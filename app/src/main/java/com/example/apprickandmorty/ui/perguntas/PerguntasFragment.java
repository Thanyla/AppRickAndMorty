package com.example.apprickandmorty.ui.perguntas;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.example.apprickandmorty.R;

public class PerguntasFragment extends Fragment {

    private PerguntasViewModel perguntasViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        perguntasViewModel =
                ViewModelProviders.of(this).get(PerguntasViewModel.class);
        View root = inflater.inflate(R.layout.fragment_perguntas, container, false);
        final TextView textView = root.findViewById(R.id.text_gallery);
        perguntasViewModel.getText().observe(this, new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                textView.setText(s);
            }
        });
        return root;
    }
}