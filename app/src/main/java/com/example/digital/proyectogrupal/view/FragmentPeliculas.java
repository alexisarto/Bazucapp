package com.example.digital.proyectogrupal.view;


import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.digital.proyectogrupal.controller.PelisController;
import com.example.digital.proyectogrupal.model.pojo.ContainerPeliculas;
import com.example.digital.proyectogrupal.model.pojo.Pelicula;
import com.example.digital.proyectogrupal.R;
import com.example.digital.proyectogrupal.utils.ResultListener;

import java.util.ArrayList;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class FragmentPeliculas extends Fragment implements AdapterPeliculas.ListenerAdapterPeliculas {

    private ListenerFragmentPelicula listenerFragmentPelicula;
    private AdapterPeliculas adapterPeliculas;
    private AdapterPeliculas adapterPeliculas2;
    private AdapterPeliculas adapterPeliculas3;
    private AdapterPeliculas adapterPeliculas4;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_peliculas,container,false);

        RecyclerView recyclerViewPeliculas= view.findViewById(R.id.recycler_biblioteca_peliculas);
       RecyclerView recyclerViewPeliculas2= view.findViewById(R.id.recycler_biblioteca_peliculas2);
        RecyclerView recyclerViewPeliculas3= view.findViewById(R.id.recycler_biblioteca_peliculas3);
        RecyclerView recyclerViewPeliculas4= view.findViewById(R.id.recycler_biblioteca_peliculas4);

        LinearLayoutManager layoutManager=new LinearLayoutManager(getContext(),LinearLayoutManager.HORIZONTAL,false);
        LinearLayoutManager layoutmanager2= new LinearLayoutManager(getContext(),LinearLayoutManager.HORIZONTAL,false);
        LinearLayoutManager layoutmanager3= new LinearLayoutManager(getContext(),LinearLayoutManager.HORIZONTAL,false);
        LinearLayoutManager layoutmanager4= new LinearLayoutManager(getContext(),LinearLayoutManager.HORIZONTAL,false);

        recyclerViewPeliculas.setLayoutManager(layoutManager);
        recyclerViewPeliculas2.setLayoutManager(layoutmanager2);
        recyclerViewPeliculas3.setLayoutManager(layoutmanager3);
        recyclerViewPeliculas4.setLayoutManager(layoutmanager4);

        adapterPeliculas= new AdapterPeliculas(this);
        adapterPeliculas2=new AdapterPeliculas(this);
        adapterPeliculas3=new AdapterPeliculas(this);
        adapterPeliculas4=new AdapterPeliculas(this);

        recyclerViewPeliculas.setAdapter(adapterPeliculas);
        recyclerViewPeliculas2.setAdapter(adapterPeliculas2);
        recyclerViewPeliculas3.setAdapter(adapterPeliculas3);
        recyclerViewPeliculas4.setAdapter(adapterPeliculas4);

        llamarpeliculas(27);
        llamarpeliculas2(16);
        llamarpeliculas3(35);
        llamarpeliculas4(878);

        return view;


    }


    public void llamarpeliculas(Integer id){
        PelisController pelisController=new PelisController();
        pelisController.searchPelis(new ResultListener<List<Pelicula>>() {
            @Override
            public void finish(List<Pelicula> result) {
                adapterPeliculas.setPeliculas(result);

            }
        },id);
    }

    public void llamarpeliculas2(Integer id){
        PelisController pelisController=new PelisController();
        pelisController.searchPelis(new ResultListener<List<Pelicula>>() {
            @Override
            public void finish(List<Pelicula> result) {

                adapterPeliculas2.setPeliculas(result);
            }
        },id);
    }

    public void llamarpeliculas3(Integer id){
        PelisController pelisController=new PelisController();
        pelisController.searchPelis(new ResultListener<List<Pelicula>>() {
            @Override
           public void finish(List<Pelicula> result) {

                adapterPeliculas3.setPeliculas(result);
            }
        },id);
    }

    public void llamarpeliculas4(Integer id){
        PelisController pelisController=new PelisController();
        pelisController.searchPelis(new ResultListener<List<Pelicula>>() {
            @Override
           public void finish(List<Pelicula> result) {

                adapterPeliculas4.setPeliculas(result);
            }
        },id);
    }



    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        listenerFragmentPelicula = (ListenerFragmentPelicula) context;
    }



    @Override
    public void informarPeliculaSeleccionada(Pelicula peliculaSeleccionada) {
        listenerFragmentPelicula.informarPeliculaSeleccionada(peliculaSeleccionada);
    }


    public interface ListenerFragmentPelicula{
        public void informarPeliculaSeleccionada(Pelicula peliculaSeleccionada);
    }


}
