package com.example.digital.proyectogrupal.view;


import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.SearchView;

import com.example.digital.proyectogrupal.R;
import com.example.digital.proyectogrupal.controller.PelisController;
import com.example.digital.proyectogrupal.model.pojo.ContainerPeliculas;
import com.example.digital.proyectogrupal.model.pojo.Pelicula;
import com.example.digital.proyectogrupal.utils.ResultListener;

import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class SearchFragment extends Fragment implements AdapterPeliculas.ListenerAdapterPeliculas {
    private AdapterPeliculas adapterPeliculas;
    private GridLayoutManager gridLayoutManager;
    private SearchView searchView;
    private ListenerSearchFragment listenerSearchFragment;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        View view=inflater.inflate(R.layout.fragment_search, container, false);
        RecyclerView recyclerViewSearch=view.findViewById(R.id.recycler_searchview);
        gridLayoutManager= new GridLayoutManager(getContext(),3);
        recyclerViewSearch.setLayoutManager(gridLayoutManager);
        searchView=view.findViewById(R.id.search_view);
        adapterPeliculas=new AdapterPeliculas(this);
        recyclerViewSearch.setAdapter(adapterPeliculas);
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {

            @Override
            public boolean onQueryTextSubmit(String s) {
                buscarPelis(s);
                return true;
            }

            @Override
            public boolean onQueryTextChange(String s) {
                return true;
            }
        });



        return view;

    }


    public void buscarPelis(String query){
        PelisController pelisController=new PelisController();
        pelisController.searchPelisview(new ResultListener<List<Pelicula>>() {
            @Override
            public void finish(List<Pelicula> result) {
                adapterPeliculas.setPeliculas(result);
            }
        },query);
    }


    @Override
    public void informarPeliculaSeleccionada(Pelicula peliculaSeleccionada) {
            listenerSearchFragment.abrirPelicula(peliculaSeleccionada);
    }


    public interface ListenerSearchFragment {
        void abrirPelicula(Pelicula peliculaSeleccionada);
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        listenerSearchFragment = (ListenerSearchFragment) context;
    }
}
