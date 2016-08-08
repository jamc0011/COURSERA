package com.jamc0011.coursera.presentador;

import android.content.Context;

import com.jamc0011.coursera.adapter.PerroAdapter;
import com.jamc0011.coursera.db.ConstructorPerros;
import com.jamc0011.coursera.fragment.IRecyclerViewFragmentView;
import com.jamc0011.coursera.pojo.Perro;

import java.util.ArrayList;

/**
 * Created by jamc0011 on 04/08/2016.
 */
public class RecyclerViewFragmentPresenter implements IRecyclerViewFragmentPresenter{

    private IRecyclerViewFragmentView iRecyclerViewFragmentView;
    private Context context;
    private ConstructorPerros constructorPerros;
    private ArrayList<Perro> perros;

    public RecyclerViewFragmentPresenter(IRecyclerViewFragmentView iRecyclerViewFragmentView, Context context){
        this.iRecyclerViewFragmentView = iRecyclerViewFragmentView;
        this.context = context;
        obtenerPerrosBaseDatos();
    }


    @Override
    public void obtenerPerrosBaseDatos() {
        constructorPerros = new ConstructorPerros(context);
        perros = constructorPerros.obtenerDatos();
        mostrarPerrosRV();
    }

    @Override
    public void mostrarPerrosRV() {
        iRecyclerViewFragmentView.inicializarAdaptadorRV(iRecyclerViewFragmentView.crearAdaptador(perros));
        iRecyclerViewFragmentView.generarLinearLayoutVertical();
    }
}
