package com.jamc0011.coursera;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.KeyEvent;
import android.view.View;

import com.jamc0011.coursera.pojo.Perro;
import com.jamc0011.coursera.adapter.PerroAdapter;

import java.util.ArrayList;

public class FavoritoActivity extends AppCompatActivity{

    ArrayList<Perro> perros;
    private RecyclerView listaPerrosFavoritos;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_favorito);

        //Mi Action Bar
        Toolbar miActionBar = (Toolbar) findViewById(R.id.actionBarMain);
        setSupportActionBar(miActionBar);

        listaPerrosFavoritos = (RecyclerView) findViewById(R.id.recyclerViewMascotasRaiting);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        listaPerrosFavoritos.setLayoutManager(linearLayoutManager);
        inicializarListaDePerrosFavoritos();
        inicializarAdapter();

    }
    public void irMainActivityDos(View v) {
        Intent itent = new Intent(this, MainActivity.class);
        startActivity(itent);
    }

    public void irFavoritosPerros(View view){
        Intent intent = new Intent(this, FavoritoActivity.class);
        startActivity(intent);
    }


    public void inicializarListaDePerrosFavoritos(){

        perros = new ArrayList<Perro>();

        perros.add(new Perro("Dina","4.9", R.drawable.perro1));
        perros.add(new Perro("Diente","4.1", R.drawable.perro2));
        perros.add(new Perro("Canela","4.1", R.drawable.perro3));
        perros.add(new Perro("Juno","4.2", R.drawable.perro4));
        perros.add(new Perro("Chispa","3", R.drawable.perro5));
    }

    public void inicializarAdapter(){
        PerroAdapter perroAdapter = new PerroAdapter(perros, this);
        listaPerrosFavoritos.setAdapter(perroAdapter);
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if(keyCode == KeyEvent.KEYCODE_BACK){
            Intent intent = new Intent(FavoritoActivity.this, MainActivity.class);
            startActivity(intent);
        }
        return super.onKeyDown(keyCode, event);
    }
}
