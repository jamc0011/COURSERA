package com.jamc0011.coursera.db;

import android.content.ContentValues;
import android.content.Context;

import com.jamc0011.coursera.R;
import com.jamc0011.coursera.pojo.Perro;

import java.util.ArrayList;

/**
 * Created by jamc0011 on 04/08/2016.
 */
public class ConstructorPerros {

    private static final int LIKE = 1;
    private Context context;
    public ConstructorPerros(Context context){
        this.context = context;

    }

    public ArrayList<Perro> obtenerDatos(){
      /*  ArrayList<Perro> perros = new ArrayList<>();
        perros = new ArrayList<>();
        perros.add(new Perro("Dina","5", R.drawable.perro1, 5));
        perros.add(new Perro("Diente","4", R.drawable.perro2, 3));
        perros.add(new Perro("Canela","4.5", R.drawable.perro3, 8));
        perros.add(new Perro("Chispa","3", R.drawable.perro4, 6));
        perros.add(new Perro("Luna","4", R.drawable.perro5, 7));
        perros.add(new Perro("Lucky","3", R.drawable.perro6, 4));
        perros.add(new Perro("Juno","3", R.drawable.perro7, 2));
        perros.add(new Perro("Pepe","4.2", R.drawable.perro8, 3));
        perros.add(new Perro("Buzz","4.6", R.drawable.perro9, 4));
        perros.add(new Perro("Sultan","3.9", R.drawable.perro10, 2));
        return perros;*/

        BaseDatos db = new BaseDatos(context);
        insertarTresPerros(db);
        return db.obtenerTodosLosPerros();
    }

    public void insertarTresPerros(BaseDatos db){

        ContentValues contentValues = new ContentValues();
        contentValues.put(ConstantesBaseDatos.TABLE_DOGS_NOMBRE, "Dina");
        contentValues.put(ConstantesBaseDatos.TABLE_DOGS_FOTO, R.drawable.perro1);

        db.insertarPerro(contentValues);

        contentValues = new ContentValues();
        contentValues.put(ConstantesBaseDatos.TABLE_DOGS_NOMBRE, "Diente");
        contentValues.put(ConstantesBaseDatos.TABLE_DOGS_FOTO, R.drawable.perro2);

        db.insertarPerro(contentValues);

        contentValues = new ContentValues();
        contentValues.put(ConstantesBaseDatos.TABLE_DOGS_NOMBRE, "Sultan");
        contentValues.put(ConstantesBaseDatos.TABLE_DOGS_FOTO, R.drawable.perro3);

        db.insertarPerro(contentValues);

        contentValues = new ContentValues();
        contentValues.put(ConstantesBaseDatos.TABLE_DOGS_NOMBRE, "Canela");
        contentValues.put(ConstantesBaseDatos.TABLE_DOGS_FOTO, R.drawable.perro4);

        db.insertarPerro(contentValues);


    }

    public void darLikePerro(Perro perro){
        BaseDatos db = new BaseDatos(context);
        ContentValues contentValues = new ContentValues();
        contentValues.put(ConstantesBaseDatos.TABLE_LIKES_DOG_ID_PERRO, perro.getId());
        contentValues.put(ConstantesBaseDatos.TABLE_LIKES_DOG_NUMERO_LIKES, LIKE);
        db.insertarLikePerro(contentValues);
    }

    public int obtenerLikesPerro(Perro perro){
        BaseDatos db = new BaseDatos(context);
        return db.obtenerLikesPerro(perro);
    }

}
