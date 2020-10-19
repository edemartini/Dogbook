package com.edemartini.dogbook.pojo;

public class Mascota {

    private int id;
    private int foto;
    private String nombre;
    private int Likes;

    public Mascota() {

    }

    public Mascota(int foto, String nombre) {
        this.foto = foto;
        this.nombre = nombre;
    }

    public Mascota(int foto, String nombre, int likes) {
        this.foto = foto;
        this.nombre = nombre;
        Likes = likes;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getFoto() {
        return foto;
    }

    public void setFoto(int foto) {
        this.foto = foto;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getLikes() {
        return Likes;
    }

    public void setLikes(int likes) {
        Likes = likes;
    }
}
