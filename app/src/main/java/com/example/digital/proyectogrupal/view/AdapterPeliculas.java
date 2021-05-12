package com.example.digital.proyectogrupal.view;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.digital.proyectogrupal.controller.PelisController;
import com.example.digital.proyectogrupal.model.pojo.Pelicula;
import com.example.digital.proyectogrupal.R;

import java.util.ArrayList;
import java.util.List;

public class AdapterPeliculas extends RecyclerView.Adapter<AdapterPeliculas.ViewHolderPeliculas> {

    private List<Pelicula> peliculas;
    private ListenerAdapterPeliculas listenerAdapterPeliculas;
    public AdapterPeliculas(ListenerAdapterPeliculas listenerAdapterPeliculas) {
        this.peliculas = new ArrayList<>();;
        this.listenerAdapterPeliculas = listenerAdapterPeliculas;
    }

    public void setPeliculas(List<Pelicula> peliculas) {
        this.peliculas = peliculas;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public ViewHolderPeliculas onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        LayoutInflater inflater = LayoutInflater.from(viewGroup.getContext());
        View view = inflater.inflate(R.layout.celda_recycler_peliculas, viewGroup, false);
        ViewHolderPeliculas viewHolderPeliculas = new ViewHolderPeliculas(view);
        return viewHolderPeliculas;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolderPeliculas viewHolderPeliculas, int i) {
        Pelicula pelicula = peliculas.get(i);
        viewHolderPeliculas.bindPelicula(pelicula);

    }


    @Override
    public int getItemCount() {
        return peliculas.size();
    }


    public class ViewHolderPeliculas extends RecyclerView.ViewHolder {

        private ImageView imageViewPelicula;


        public ViewHolderPeliculas(@NonNull View itemView) {
            super(itemView);
            imageViewPelicula = itemView.findViewById(R.id.celda_imageview_peliculas);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Pelicula pelicula = peliculas.get(getAdapterPosition());

                    listenerAdapterPeliculas.informarPeliculaSeleccionada(pelicula);


                }
            });
        }
//        public class ViewHolderSearch extends RecyclerView.ViewHolder{
//            private ImageView imageViewSearch;
//            private TextView textViewSearch;
//            public ViewHolderSearch(@NonNull View itemView) {
//                super(itemView);
//                imageViewSearch=itemView.findViewById(R.id.imageview_search);
//                textViewSearch=itemView.findViewById(R.id.textview_search);
//                itemView.setOnClickListener(new View.OnClickListener() {
//                    @Override
//                    public void onClick(View view) {
//                        Pelicula pelicula=peliculas.get(getAdapterPosition());
//                        listenerAdapterPeliculas.informarPeliculaSeleccionada(pelicula);
//                    }
//                });
//            }
//        }





        public void bindPelicula(Pelicula pelicula) {
            Glide.with(itemView).load("https://image.tmdb.org/t/p/w500/"+pelicula.getImagen()).into(imageViewPelicula);
        }

    }

    public interface ListenerAdapterPeliculas {
        void informarPeliculaSeleccionada(Pelicula peliculaSeleccionada);
    }


}