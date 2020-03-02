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
    private TextView textView;
    private final String introducao = "Rick and Morty nasceu como uma sátira/homenagem" +
            " ao icônico duo de protagonistas Doc Brown e Marty, dos filmes " +
            "De Volta Para o Futuro, lançados na década de 1980.";

    private final String paragrafo1 = "\nRick and Morty, uma reedição existencialista, " +
            "politicamente incorreta e brutalmente humana da clássica saga, " +
            "superou a premissa “emprestada” e consagrou-se como um programa " +
            "original por méritos próprios.";
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        View root = inflater.inflate(R.layout.fragment_serie, container, false);
        textView = root.findViewById(R.id.text_home);
        textView.setText(introducao);

        textView.append(paragrafo1);
        textView.append(paragrafo1);



        return root;
    }
}