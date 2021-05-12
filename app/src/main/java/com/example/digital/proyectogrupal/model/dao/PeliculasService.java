package com.example.digital.proyectogrupal.model.dao;

import com.example.digital.proyectogrupal.model.pojo.ContainerPeliculas;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface PeliculasService {


    @GET("trending/movie/week?")
    Call<ContainerPeliculas> getTrendingPelis(@Query("api_key")String apikey);

    @GET("discover/movie")
    Call<ContainerPeliculas> getPelisPorCategoria(@Query("api_key")String apikey,@Query("with_genres") Integer id);

    @GET("search/movie")
    Call<ContainerPeliculas> getPelis(@Query("query") String query, @Query("api_key")String apikey);

    //https://api.themoviedb.org/3/search/movie?query=batman&api_key=06e257022bcccbc47b29e95b35ab8370


   // {"genres":[{"id":28,"name":"Action"},{"id":12,"name":"Adventure"},{"id":16,"name":"Animation"},{"id":35,"name":"Comedy"},{"id":80,"name":"Crime"},{"id":99,"name":"Documentary"},{"id":18,"name":"Drama"},{"id":10751,"name":"Family"},{"id":14,"name":"Fantasy"},{"id":36,"name":"History"},{"id":27,"name":"Horror"},{"id":10402,"name":"Music"},{"id":9648,"name":"Mystery"},{"id":10749,"name":"Romance"},{"id":878,"name":"Science Fiction"},{"id":10770,"name":"TV Movie"},{"id":53,"name":"Thriller"},{"id":10752,"name":"War"},{"id":37,"name":"Western"}]}
}
