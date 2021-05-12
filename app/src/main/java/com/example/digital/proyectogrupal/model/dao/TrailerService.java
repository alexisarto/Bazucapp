package com.example.digital.proyectogrupal.model.dao;

import com.example.digital.proyectogrupal.model.pojo.ContainerPeliculas;
import com.example.digital.proyectogrupal.model.pojo.TrailerContainer;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface TrailerService {

    @GET("movie/{id}/videos")
    Call<TrailerContainer> getTrailer(@Path("id") String id, @Query("api_key")String apikey);

}
