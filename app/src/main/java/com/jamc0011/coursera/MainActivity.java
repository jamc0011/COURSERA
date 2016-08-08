package com.jamc0011.coursera;

import android.content.Intent;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.jamc0011.coursera.adapter.PageAdapter;
import com.jamc0011.coursera.adapter.PerroAdapter;
import com.jamc0011.coursera.fragment.PerfilFragment;
import com.jamc0011.coursera.fragment.RecyclerViewFragment;
import com.jamc0011.coursera.pojo.Perro;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {


    private Toolbar toolbar;
    private TabLayout tabLayout;
    private ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);


        toolbar = (Toolbar) findViewById(R.id.toolbar);
        tabLayout = (TabLayout) findViewById(R.id.tabLayout);
        viewPager = (ViewPager) findViewById(R.id.viewPager);
        setUpViewPager();



        if (toolbar != null){
            setSupportActionBar(toolbar);
        }
    }

    //sobreescribe el metodo e infla o muestra el menu en la lista de MENU OPCIONES
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_opciones, menu);

        return true;
    }

    //Con este metodo controlamos si selecciono setting o about(opciones del menu) que va a suceder
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.imageButtonRaiting:
                //intent para ir a otra pantalla
                Intent intent = new Intent(this, FavoritoActivity.class);
                startActivity(intent);
                break;
            case R.id.mContacto:
                //intent para ir a otra pantalla
                Intent inten = new Intent(this, ContactoMail.class);
                startActivity(inten);
                break;
            //INTEGRANDO ACTION VIEW
            case R.id.mAcerdade:
                //intent para ir a otra pantalla
                Intent inte = new Intent(this, AcercaDe.class);
                startActivity(inte);
                break;
        }

        return super.onOptionsItemSelected(item);
    }

    private ArrayList<Fragment> agregarFragments(){
        ArrayList<Fragment> fragments = new ArrayList<>();
        fragments.add(new RecyclerViewFragment());
        fragments.add(new PerfilFragment());

        return fragments;
    }

    private void setUpViewPager(){
        viewPager.setAdapter(new PageAdapter(getSupportFragmentManager(), agregarFragments()));
        tabLayout.setupWithViewPager(viewPager);

        tabLayout.getTabAt(0).setIcon(R.drawable.home_50);
        tabLayout.getTabAt(1).setIcon(R.drawable.year_of_dog_50);
    }



    public void irFavoritosPerros(View view){
        Intent intent = new Intent(this, FavoritoActivity.class);
        startActivity(intent);
    }
}