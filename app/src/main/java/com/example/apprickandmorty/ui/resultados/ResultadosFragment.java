package com.example.apprickandmorty.ui.resultados;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.example.apprickandmorty.R;

public class ResultadosFragment extends Fragment {

    TextView textView;
    ImageView imageView;
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_resultados, container, false);
        textView = root.findViewById(R.id.text_resultado);
        imageView = root.findViewById(R.id.imageViewResultado);
        String resposta = this.getArguments().getString("resultado");
        textView.setText(resposta);

        if(resposta == "Rick")
            imageView.setImageResource(R.drawable.rick);
        if(resposta == "Morty")
            imageView.setImageResource(R.drawable.morty);
        if (resposta == "Jerry")
            imageView.setImageResource(R.drawable.jerry);
        if (resposta == "Summer")
            imageView.setImageResource(R.drawable.summer);

        System.out.println(resposta);
        return root;
    }
}