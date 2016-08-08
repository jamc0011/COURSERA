package com.jamc0011.coursera.db;

import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.jamc0011.coursera.pojo.Perro;

import java.util.ArrayList;

/**
 * Created by jamc0011 on 05/08/2016.
 */
public class BaseDatos extends SQLiteOpenHelper {

    private Context context;

    public BaseDatos(Context context) {
        super(context, ConstantesBaseDatos.TABLE_DOGS, null, ConstantesBaseDatos.DATABASE_VERSION);
        this.context = context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        String queryCrearTablaPerro = "CREATE TABLE " + ConstantesBaseDatos.TABLE_DOGS + "(" +
                ConstantesBaseDatos.TABLE_DOGS_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                ConstantesBaseDatos.TABLE_DOGS_NOMBRE + " TEXT, " +
                ConstantesBaseDatos.TABLE_DOGS_FOTO + " INTEGER" +
                ")";

        String queryCrearTablaLikesPerro = "CREATE TABLE " + ConstantesBaseDatos.TABLE_LIKES_DOG + "(" +
                ConstantesBaseDatos.TABLE_LIKES_DOG_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                ConstantesBaseDatos.TABLE_LIKES_DOG_ID_PERRO + " INTEGER, " +
                ConstantesBaseDatos.TABLE_LIKES_DOG_NUMERO_LIKES + " INTEGER, " +
                "FOREIGN KEY (" + ConstantesBaseDatos.TABLE_LIKES_DOG_ID_PERRO + ") " +
                "REFERENCES "+ ConstantesBaseDatos.TABLE_DOGS + "("+ ConstantesBaseDatos.TABLE_DOGS_ID +")"+
                 ")";

        db.execSQL(queryCrearTablaPerro);
        db.execSQL(queryCrearTablaLikesPerro);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        db.execSQL("DROP TABLE IF EXIST "+ ConstantesBaseDatos.TABLE_DOGS);
        db.execSQL("DROP TABLE IF EXIST "+ ConstantesBaseDatos.TABLE_LIKES_DOG);
        onCreate(db);
    }

    public ArrayList<Perro> obtenerTodosLosPerros(){
        ArrayList<Perro> perros = new ArrayList<>();

        String query = "SELECT * FROM " + ConstantesBaseDatos.TABLE_DOGS;
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor registros = db.rawQuery(query, null);

        while (registros.moveToNext()){
            Perro perroActual = new Perro();
            perroActual.setId(registros.getInt(0));
            perroActual.setNombre(registros.getString(1));
            perroActual.setFoto(registros.getInt(2));

            String queryLikes = "SELECT COUNT("+ConstantesBaseDatos.TABLE_LIKES_DOG_NUMERO_LIKES+") as likes " +
                    " FROM " + ConstantesBaseDatos.TABLE_LIKES_DOG +
                    " WHERE " + ConstantesBaseDatos.TABLE_LIKES_DOG_ID_PERRO + "=" + perroActual.getId();

            Cursor registrosLikes = db.rawQuery(queryLikes, null);
            if (registrosLikes.moveToNext()){
                perroActual.setLikes(registrosLikes.getInt(0));
            }else {
                perroActual.setLikes(0);
            }



            perros.add(perroActual);
        }

        db.close();

        return perros;

    }

    public void insertarPerro(ContentValues contentValues){
        SQLiteDatabase db = this.getWritableDatabase();

        db.insert(ConstantesBaseDatos.TABLE_DOGS,null, contentValues);
        db.close();
    }

    public void insertarLikePerro(ContentValues contentValues){
        SQLiteDatabase db = this.getWritableDatabase();
        db.insert(ConstantesBaseDatos.TABLE_LIKES_DOG, null, contentValues);
        db.close();
    }


    public int obtenerLikesPerro(Perro perro){
        int likes = 0;

            String query = "SELECT COUNT("+ConstantesBaseDatos.TABLE_LIKES_DOG_NUMERO_LIKES+")" +
                    " FROM " + ConstantesBaseDatos.TABLE_LIKES_DOG +
                    " WHERE " + ConstantesBaseDatos.TABLE_LIKES_DOG_ID_PERRO + "="+perro.getId();
            SQLiteDatabase db = this.getWritableDatabase();
            Cursor registros = db.rawQuery(query, null);
            if (registros.moveToNext()){
                    likes = registros.getInt(0);
            }
            db.close();

        return likes;
    }
}
