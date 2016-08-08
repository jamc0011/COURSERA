package com.jamc0011.coursera.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.jamc0011.coursera.R;
import com.jamc0011.coursera.adapter.PerroAdapter;
import com.jamc0011.coursera.pojo.Perro;

import java.util.ArrayList;

/**
 * Created by jamc0011 on 26/07/2016.
 */
public class PerfilFragment extends Fragment{
    ArrayList<Perro> perros;
    private RecyclerView listaPerros;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        // return super.onCreateView(inflater, container, savedInstanceState);
        View v = inflater.inflate(R.layout.fragment_perfil, container, false);

        listaPerros = (RecyclerView) v.findViewById(R.id.recyclerViewMascotasDos);



        StaggeredGridLayoutManager staggeredGridLayoutManager = new StaggeredGridLayoutManager(3, StaggeredGridLayoutManager.VERTICAL);
        listaPerros.setLayoutManager(staggeredGridLayoutManager);
        inicializarListaDePerrosDos();
        inicializarAdapterDos();

        return v;
    }


    public void inicializarListaDePerrosDos(){

        perros = new ArrayList<Perro>();


        perros.add(new Perro(R.drawable.perro2, 0));
        perros.add(new Perro(R.drawable.perro3,0));
        perros.add(new Perro(R.drawable.perro4,0));
        perros.add(new Perro(R.drawable.perro6,0));
        perros.add(new Perro(R.drawable.perro7,0));
        perros.add(new Perro(R.drawable.perro8,0));
        perros.add(new Perro(R.drawable.perro1,0));
        perros.add(new Perro(R.drawable.perro2,0));
        perros.add(new Perro(R.drawable.perro3,0));
        perros.add(new Perro(R.drawable.perro4,0));
        perros.add(new Perro(R.drawable.perro6,0));
        perros.add(new Perro(R.drawable.perro7,0));
        perros.add(new Perro(R.drawable.perro8,0));
        perros.add(new Perro(R.drawable.perro9,0));



    }

    //Metodo para inicializar el adaptador

    public void inicializarAdapterDos(){
        PerroAdapter perroAdapter = new PerroAdapter(perros, getActivity());
        listaPerros.setAdapter(perroAdapter);
    }

}

