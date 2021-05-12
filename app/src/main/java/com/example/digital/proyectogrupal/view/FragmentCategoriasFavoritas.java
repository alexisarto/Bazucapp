package com.example.digital.proyectogrupal.view;


import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.digital.proyectogrupal.view.AdapterCategoriasfav.ListenerAdapterCategorias;
import com.example.digital.proyectogrupal.model.pojo.Categorias;
import com.example.digital.proyectogrupal.R;

import java.util.ArrayList;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class FragmentCategoriasFavoritas extends Fragment implements ListenerAdapterCategorias{


    private ListenerFragmentCategoria listenerFragmentCategoria;

    public FragmentCategoriasFavoritas() {

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_categorias_favoritas, container, false);

        GridLayoutManager gridLayoutManager = new GridLayoutManager(getContext(), 2);
        RecyclerView recyclerView = view.findViewById(R.id.recycler_categorias_favoritas);
        recyclerView.setLayoutManager(gridLayoutManager);

        final AdapterCategoriasfav adapterCategoriasfav = new AdapterCategoriasfav(cargarCategoria());
        recyclerView.setAdapter(adapterCategoriasfav);


//        Button button = view.findViewById(R.id.botonIngresarCategoriasFav);
//
//        button.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                listenerFragmentCategoria.informarCategoriaSeleccionada();
//            }
//        });
//        // recyclerView2.setAdapter(adapterCategoriasfav2);
        return view;


    }

    private List cargarCategoria() {
        List<Categorias> listaCategorias = new ArrayList<>();

        listaCategorias.add(new Categorias(R.drawable.terror2, "Terror",28));
       listaCategorias.add(new Categorias(R.drawable.anime, "Anime",28));
        listaCategorias.add(new Categorias(R.drawable.humor, "Humor",28));
        listaCategorias.add(new Categorias(R.drawable.cienciaficcion, "Ficcion",28));
        listaCategorias.add(new Categorias(R.drawable.deportes, "Deportes",28));
        listaCategorias.add(new Categorias(R.drawable.romance, "Romance",28));


        return listaCategorias;

    }


    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        listenerFragmentCategoria = (ListenerFragmentCategoria) context;
    }

    @Override
    public void informarCategoriaSeleccionada(Categorias categoriaSeleccionada) {
        //listenerFragmentCategoria.informarCategoriaSeleccionada(categoriaSeleccionada);
    }


    public interface ListenerFragmentCategoria {
        public void informarCategoriaSeleccionada();
    }


}