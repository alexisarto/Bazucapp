package com.example.digital.proyectogrupal.model.pojo;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class ContainerPeliculas {
    @SerializedName("results")
private List<Pelicula> listadepeliculas;

    public List<Pelicula> getListadepeliculas() {
        return listadepeliculas;
    }
}
