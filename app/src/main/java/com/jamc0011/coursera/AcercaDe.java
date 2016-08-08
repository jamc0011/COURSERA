package com.jamc0011.coursera;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;

public class AcercaDe extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_acerca_de);

        //Mi Action Bar
        Toolbar miActionBar = (Toolbar) findViewById(R.id.actionBarMain);
        setSupportActionBar(miActionBar);


    }

    public void irMainActivityDos(View v) {
        Intent itent = new Intent(this, MainActivity.class);
        startActivity(itent);
    }

    public void irFavoritosPerros(View view){
        Intent intent = new Intent(this, FavoritoActivity.class);
        startActivity(intent);
    }
}
