package com.example.digital.proyectogrupal.controller;

import com.example.digital.proyectogrupal.model.dao.DAOPeliculas;
import com.example.digital.proyectogrupal.model.dao.DAOTrailer;
import com.example.digital.proyectogrupal.model.pojo.ContainerPeliculas;
import com.example.digital.proyectogrupal.model.pojo.Pelicula;
import com.example.digital.proyectogrupal.model.pojo.TrailerContainer;
import com.example.digital.proyectogrupal.utils.ResultListener;

import java.util.List;

public class PelisController {

  public void searchPelis(final ResultListener<List<Pelicula>>listener,Integer id ){
      DAOPeliculas daoPeliculas=new DAOPeliculas();
      daoPeliculas.getPelisPorCategoria(new ResultListener<ContainerPeliculas>() {
          @Override
          public void finish(ContainerPeliculas result) {
              listener.finish(result.getListadepeliculas());
          }
      },id);
  }

  public void getTrailerFromPelicula(final ResultListener<TrailerContainer> listener, String id){
      DAOTrailer daoTrailer = new DAOTrailer();
      daoTrailer.getTrailer(new ResultListener<TrailerContainer>() {
          @Override
          public void finish(TrailerContainer result) {
              listener.finish(result);
          }
      }, id);
  }

  public void searchPelisview(final ResultListener<List<Pelicula>>listener, String query){
      DAOPeliculas daoPeliculas=new DAOPeliculas();
      daoPeliculas.getPelisByQuery(new ResultListener<ContainerPeliculas>() {
          @Override
          public void finish(ContainerPeliculas result) {
              listener.finish(result.getListadepeliculas());
          }
      },query);


  }
}
