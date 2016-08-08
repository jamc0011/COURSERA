package com.jamc0011.coursera.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.jamc0011.coursera.R;
import com.jamc0011.coursera.adapter.PerroAdapter;
import com.jamc0011.coursera.pojo.Perro;
import com.jamc0011.coursera.presentador.IRecyclerViewFragmentPresenter;
import com.jamc0011.coursera.presentador.RecyclerViewFragmentPresenter;

import java.util.ArrayList;

/**
 * Created by jamc0011 on 26/07/2016.
 */
public class RecyclerViewFragment extends Fragment implements IRecyclerViewFragmentView{
    ArrayList<Perro> perros;
    private RecyclerView listaPerros;
    private IRecyclerViewFragmentPresenter presenter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        // return super.onCreateView(inflater, container, savedInstanceState);
        View v = inflater.inflate(R.layout.fragment_recyclerview, container, false);

        listaPerros = (RecyclerView) v.findViewById(R.id.recyclerViewMascotas);
        presenter = new RecyclerViewFragmentPresenter(this, getContext());
        return v;
    }

    /*
    public void inicializarListaDePerros(){

        perros = new ArrayList<Perro>();

        perros.add(new Perro("Dina","5", R.drawable.perro1, likes));
        perros.add(new Perro("Diente","4", R.drawable.perro2, likes));
        perros.add(new Perro("Canela","4.5", R.drawable.perro3, likes));
        perros.add(new Perro("Chispa","3", R.drawable.perro4, likes));
        perros.add(new Perro("Luna","4", R.drawable.perro5, likes));
        perros.add(new Perro("Lucky","3", R.drawable.perro6, likes));
        perros.add(new Perro("Juno","3", R.drawable.perro7, likes));
        perros.add(new Perro("Pepe","4.2", R.drawable.perro8, likes));
        perros.add(new Perro("Buzz","4.6", R.drawable.perro9, likes));
        perros.add(new Perro("Sultan","3.9",R.drawable.perro10, likes));

    }*/



    @Override
    public void generarLinearLayoutVertical() {
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        listaPerros.setLayoutManager(linearLayoutManager);
    }

    @Override
    public PerroAdapter crearAdaptador(ArrayList<Perro> perros) {
        PerroAdapter perroAdapter = new PerroAdapter(perros, getActivity());
        return perroAdapter;
    }

    @Override
    public void inicializarAdaptadorRV(PerroAdapter adaptador) {
        listaPerros.setAdapter(adaptador);
    }
}

