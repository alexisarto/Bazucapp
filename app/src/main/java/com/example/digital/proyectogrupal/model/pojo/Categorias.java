package com.example.digital.proyectogrupal.model.pojo;

import android.widget.ImageView;
import android.widget.TextView;

public class Categorias {
    private Integer imagenCategoriasFav;
    private String nombreCategoriasFav;
    private Integer id;

    public Categorias(Integer imagenCategoriasFav, String nombreCategoriasFav, Integer id) {
        this.imagenCategoriasFav = imagenCategoriasFav;
        this.nombreCategoriasFav = nombreCategoriasFav;
        this.id=id;
    }

    public Integer getImagenCategoriasFav() {
        return imagenCategoriasFav;
    }

    public void setImagenCategoriasFav(Integer imagenCategoriasFav) {
        this.imagenCategoriasFav = imagenCategoriasFav;
    }

    public String getNombreCategoriasFav() {
        return nombreCategoriasFav;
    }

    public void setNombreCategoriasFav(String nombreCategoriasFav) {
        this.nombreCategoriasFav = nombreCategoriasFav;
    }

    public Integer getId() {
        return id;
    }
}
