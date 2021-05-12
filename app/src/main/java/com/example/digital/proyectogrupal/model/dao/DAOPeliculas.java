package com.example.digital.proyectogrupal.model.dao;

import android.content.res.AssetManager;

import com.example.digital.proyectogrupal.controller.PelisController;
import com.example.digital.proyectogrupal.model.pojo.ContainerPeliculas;
import com.example.digital.proyectogrupal.model.pojo.Pelicula;
import com.example.digital.proyectogrupal.utils.ResultListener;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class DAOPeliculas extends MyRetrofit{
    private PeliculasService peliculasService;
    public static final String baseURL ="https://api.themoviedb.org/3/";
    public static final String APIKEY ="06e257022bcccbc47b29e95b35ab8370";


    public DAOPeliculas() {
        super(baseURL);
        peliculasService=retrofit.create(PeliculasService.class);
    }

    public void getPelisPorCategoria(final ResultListener<ContainerPeliculas>listener, Integer id){
        Call<ContainerPeliculas> call=peliculasService.getPelisPorCategoria(APIKEY, id);
        call.enqueue(new Callback<ContainerPeliculas>() {
            @Override
            public void onResponse(Call<ContainerPeliculas> call, Response<ContainerPeliculas> response) {
                listener.finish(response.body());


            }

            @Override
            public void onFailure(Call<ContainerPeliculas> call, Throwable t) {
                t.printStackTrace();

            }
        });
    }
    public void getPelisByQuery(final ResultListener<ContainerPeliculas>listener,String query){
        Call<ContainerPeliculas> call=peliculasService.getPelis(query, APIKEY);
        call.enqueue(new Callback<ContainerPeliculas>() {
            @Override
            public void onResponse(Call<ContainerPeliculas> call, Response<ContainerPeliculas> response) {
                listener.finish(response.body());
            }

            @Override
            public void onFailure(Call<ContainerPeliculas> call, Throwable t) {
                t.printStackTrace();
            }
        });

    }
}
