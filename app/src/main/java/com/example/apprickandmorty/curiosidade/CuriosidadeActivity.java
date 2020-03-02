package com.example.apprickandmorty.curiosidade;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.TextView;

import com.example.apprickandmorty.R;

import java.util.List;

public class CuriosidadeActivity extends AppCompatActivity {

    TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_curiosidade);

        //Ativar opção(seta) para retornar a activity anterior
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        textView = findViewById(R.id.text_curiosidade);
        textView.setText(R.string.curiosidade1);
        textView = findViewById(R.id.text_curiosidade2);
        textView.setText(R.string.curiosidade2);

    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                finish();
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}
