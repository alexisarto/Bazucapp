package com.example.digital.proyectogrupal.view;

import android.support.annotation.NonNull;
import android.support.v7.view.menu.MenuView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.example.digital.proyectogrupal.R;
import com.example.digital.proyectogrupal.model.pojo.Pelicula;

import java.util.ArrayList;
import java.util.List;

public class AdapterFavoritos extends RecyclerView.Adapter<AdapterFavoritos.ViewHolderFavoritos>{
    private List<Pelicula> peliculas;
    private AdapterFavoritos.ListenerAdapterFavoritos listenerAdapterFavoritos;
    public AdapterFavoritos(AdapterFavoritos.ListenerAdapterFavoritos listenerAdapterFavoritos){
        this.peliculas=new ArrayList<>();
        this.listenerAdapterFavoritos=listenerAdapterFavoritos;
    }


    public void setPeliculas(List<Pelicula> peliculas) {
        this.peliculas = peliculas;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public ViewHolderFavoritos onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolderFavoritos viewHolderFavoritos, int i) {
    Pelicula pelicula=peliculas.get(i);
    viewHolderFavoritos.bindPelicula(pelicula);
    }

    @Override
    public int getItemCount() {
        return peliculas.size();
    }


      public class ViewHolderFavoritos extends RecyclerView.ViewHolder {
        private ImageView imageViewFavoritos;



    public ViewHolderFavoritos(@NonNull View itemView) {
        super(itemView);
        imageViewFavoritos=itemView.findViewById(R.id.celda_pelicula_favorita);
        itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
    }

        public void bindPelicula(Pelicula pelicula) {
            Glide.with(itemView).load("https://image.tmdb.org/t/p/w500/"+pelicula.getImagen()).into(imageViewFavoritos);
        }
}



        public interface ListenerAdapterFavoritos{
        void informarPeliculaSeleccionada(Pelicula peliculaSeleccionada);
        }



}
