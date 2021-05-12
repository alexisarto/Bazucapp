package com.example.digital.proyectogrupal.model.dao;




import com.example.digital.proyectogrupal.model.pojo.TrailerContainer;
import com.example.digital.proyectogrupal.utils.ResultListener;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DAOTrailer extends MyRetrofit{
    public static final String API_KEY = "AIzaSyA30mmXL8zblfw3oGTpbInm6daP3k1dJHQ";
    private TrailerService trailerService;


    public DAOTrailer() {
        super(DAOPeliculas.baseURL);
        trailerService = retrofit.create(TrailerService.class);
    }

    public void getTrailer(final ResultListener<TrailerContainer> listener, String id){
        Call<TrailerContainer> call = trailerService.getTrailer(id, DAOPeliculas.APIKEY);
        call.enqueue(new Callback<TrailerContainer>() {
            @Override
            public void onResponse(Call<TrailerContainer> call, Response<TrailerContainer> response) {
                listener.finish(response.body());
            }

            @Override
            public void onFailure(Call<TrailerContainer> call, Throwable t) {

            }
        });
    }
}
