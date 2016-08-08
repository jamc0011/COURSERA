package com.jamc0011.coursera.fragment;

import com.jamc0011.coursera.adapter.PerroAdapter;
import com.jamc0011.coursera.pojo.Perro;

import java.util.ArrayList;

/**
 * Created by jamc0011 on 04/08/2016.
 */
public interface IRecyclerViewFragmentView {

    public void  generarLinearLayoutVertical();

    public PerroAdapter crearAdaptador(ArrayList<Perro> perros);

    public void inicializarAdaptadorRV(PerroAdapter adaptador);
}
