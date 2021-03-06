package com.example.apprickandmorty;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import com.example.apprickandmorty.curiosidade.CuriosidadeActivity;
import com.example.apprickandmorty.middlewares.Regras;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import android.provider.MediaStore;
import android.view.MenuItem;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.google.android.material.navigation.NavigationView;

import androidx.drawerlayout.widget.DrawerLayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.Menu;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private AppBarConfiguration mAppBarConfiguration;
    Regras regras = new Regras();
    String personagem;
    Bundle bundle = new Bundle();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                startActivity(intent);
            }
        });
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id.nav_view);
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        mAppBarConfiguration = new AppBarConfiguration.Builder(
                R.id.nav_serie, R.id.nav_perguntas, R.id.nav_resultados,
                R.id.nav_tools)
                .setDrawerLayout(drawer)
                .build();
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        NavigationUI.setupActionBarWithNavController(this, navController, mAppBarConfiguration);
        NavigationUI.setupWithNavController(navigationView, navController);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    //Adicionar método onOptionsItemSelected para tratar menu simples (Layout: menu/main.xml
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.action_curiosidades:
                Toast.makeText(getApplicationContext(), "Curiosidade", Toast.LENGTH_SHORT).show();
                Intent i = new Intent(this, CuriosidadeActivity.class);
                startActivity(i);
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onSupportNavigateUp() {
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        return NavigationUI.navigateUp(navController, mAppBarConfiguration)
                || super.onSupportNavigateUp();
    }

    public void onClickResultadosQuiz(View view) {
        RadioGroup radioButtonGroup1 = (RadioGroup) findViewById(R.id.radioGroup1);
        int pergunta1 = radioButtonGroup1.getCheckedRadioButtonId();
        RadioButton resposta = (RadioButton) findViewById(pergunta1);
        regras.addPeso(Integer.parseInt(resposta.getTag().toString()));

        RadioGroup radioButtonGroup2 = (RadioGroup) findViewById(R.id.radioGroup2);
        int pergunta2 = radioButtonGroup1.getCheckedRadioButtonId();
        RadioButton resposta2 = (RadioButton) findViewById(pergunta2);
        regras.addPeso(Integer.parseInt(resposta2.getTag().toString()));

        RadioGroup radioButtonGroup3 = (RadioGroup) findViewById(R.id.radioGroup3);
        int pergunta3 = radioButtonGroup1.getCheckedRadioButtonId();
        RadioButton resposta3 = (RadioButton) findViewById(pergunta3);
        regras.addPeso(Integer.parseInt(resposta3.getTag().toString()));

        System.out.println(regras.getVencedor());
        personagem = regras.getVencedor();

        bundle.putString("resultado", personagem);


        regras = new Regras();

        Navigation.findNavController(this, R.id.nav_host_fragment).navigate(R.id.nav_resultados, bundle);
    }
}
