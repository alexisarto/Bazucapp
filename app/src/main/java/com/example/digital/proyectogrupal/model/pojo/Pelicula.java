package com.example.digital.proyectogrupal.model.pojo;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class Pelicula implements Serializable {

    private String id;
    @SerializedName("poster_path")
    private String imagen;
    @SerializedName("original_title")
    private String nombre_pelicula;
    @SerializedName("overview")
    private String sinopsis;
    @SerializedName("original_language")
    private String lenguaje;
    @SerializedName("video")
    private Boolean video;
    private TrailerContainer trailerContainer;

    public void setTrailerContainer(TrailerContainer trailerContainer) {
        this.trailerContainer = trailerContainer;
    }

    public Boolean getVideo() {
        return video;
    }

    public TrailerContainer getTrailerContainer() {
        return trailerContainer;
    }

    public String getId() {
        return id;
    }

    public String getImagen() {
        return imagen;
    }

    public String getNombre_pelicula() {
        return nombre_pelicula;
    }

    public String getSinopsis() {
        return sinopsis;
    }


}

