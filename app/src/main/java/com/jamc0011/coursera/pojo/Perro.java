package com.jamc0011.coursera.pojo;

public class Perro {

    private int id;
    private String nombre;
    private int foto;
    private int likes;
    private String favorito;



    public Perro(String nombre, int foto, int likes) {
        this.nombre = nombre;
        this.foto = foto;
        this.likes = likes;

    }


    public Perro(String nombre, String favorito, int foto) {
        this.nombre = nombre;
        this.favorito = favorito;
        this.foto = foto;
    }

    public Perro(int foto, int likes) {
        this.foto = foto;
        this.likes = likes;
    }

    public Perro() {

    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getFoto() {
        return foto;
    }

    public void setFoto(int foto) {
        this.foto = foto;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getLikes() {
        return likes;
    }

    public void setLikes(int likes) {
        this.likes = likes;
    }
}


