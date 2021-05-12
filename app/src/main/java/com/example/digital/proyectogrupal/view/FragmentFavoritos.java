package com.example.digital.proyectogrupal.view;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.digital.proyectogrupal.model.pojo.Pelicula;

/**
 * A simple {@link Fragment} subclass.
 */
public class FragmentFavoritos extends Fragment implements AdapterPeliculas.ListenerAdapterPeliculas {
    private ImageView corazonVacio;
    private AdapterPeliculas adapterPeliculas;
    private GridLayoutManager gridLayoutManager;
    private ListenerFragmentFavoritos listenerFragmentFavoritos;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =inflater.inflate(R.layout.fragment_favoritos, container, false);
        corazonVacio=view.findViewById(R.id.corazon_vacio_fav);
        corazonVacio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });






        return view;
    }

    public interface ListenerFragmentFavoritos{
        void abrirPelicula(Pelicula peliculaSeleccionada);
    }

    @Override
    public void informarPeliculaSeleccionada(Pelicula peliculaSeleccionada) {
        listenerFragmentFavoritos.abrirPelicula(peliculaSeleccionada);

    }
}
