package com.example.digital.proyectogrupal.view;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.digital.proyectogrupal.model.pojo.Categorias;
import com.example.digital.proyectogrupal.R;

import java.util.List;

public class AdapterCategoriasfav extends RecyclerView.Adapter<AdapterCategoriasfav.ViewHolderCategorias>{

    private List<Categorias> listaDeCategoriasFavoritas;
    private ListenerAdapterCategorias listenerAdapterCategorias;



    public AdapterCategoriasfav(List<Categorias> listaDeCategoriasFavoritas) {
        this.listaDeCategoriasFavoritas = listaDeCategoriasFavoritas;
        this.listenerAdapterCategorias = listenerAdapterCategorias;

    }

    public class ViewHolderCategorias extends RecyclerView.ViewHolder {
        private ImageView imageViewCategoriasFav;
        private TextView textViewCategoriaFav;

        public ViewHolderCategorias(@NonNull View itemView) {
            super(itemView);
            imageViewCategoriasFav=itemView.findViewById(R.id.imageViewCeldaCategoria);
            textViewCategoriaFav = itemView.findViewById(R.id.text_categoria);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    Categorias categorias = listaDeCategoriasFavoritas.get(getAdapterPosition());


                    //listenerAdapterCategorias.informarCategoriaSeleccionada(categorias);
                }
            });



        }

        public void bindCategoria (Categorias categorias) {
            imageViewCategoriasFav.setImageResource(categorias.getImagenCategoriasFav());
            textViewCategoriaFav.setText(categorias.getNombreCategoriasFav());
        }

    }


    @NonNull
    @Override
    public ViewHolderCategorias onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

        LayoutInflater inflater = LayoutInflater.from(viewGroup.getContext());
        View view = inflater.inflate(R.layout.fragment_celda_categorias_favoritas, viewGroup, false);
        ViewHolderCategorias viewHolderCategorias = new ViewHolderCategorias(view);


        return viewHolderCategorias;

    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolderCategorias viewHolderCategorias, int i) {
        Categorias categoria = listaDeCategoriasFavoritas.get(i);
        viewHolderCategorias.bindCategoria(categoria);


    }


    @Override
    public int getItemCount() {
        return listaDeCategoriasFavoritas.size();
    }

    public interface ListenerAdapterCategorias {
        public void informarCategoriaSeleccionada(Categorias categoriaSeleccionada);
    }

}
