package com.example.apprickandmorty.ui.serie;

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

public class SerieFragment extends Fragment {

    private SerieViewModel serieViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        serieViewModel =
                ViewModelProviders.of(this).get(SerieViewModel.class);
        View root = inflater.inflate(R.layout.fragment_serie, container, false);
        final TextView textView = root.findViewById(R.id.text_home);
        serieViewModel.getText().observe(this, new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                textView.setText(s);
            }
        });
        return root;
    }
}