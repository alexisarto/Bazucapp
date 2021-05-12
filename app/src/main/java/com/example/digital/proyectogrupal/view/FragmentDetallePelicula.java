package com.example.digital.proyectogrupal.view;


import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;



import com.bumptech.glide.Glide;
import com.example.digital.proyectogrupal.controller.PelisController;
import com.example.digital.proyectogrupal.model.pojo.Pelicula;
import com.example.digital.proyectogrupal.R;
import com.example.digital.proyectogrupal.utils.ResultListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;


/**
 * A simple {@link Fragment} subclass.
 */
public class FragmentDetallePelicula extends FragmentPeliculas {

public static final String CLAVE_PELICULA="pelicula";
private ImageView corazonButton;
private Pelicula peliculaSeleccionada;
private PelisController pelisController;
private Boolean isFav;



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_fragment__detalle__pelicula,container,false);
        ImageView imageViewImagen= view.findViewById(R.id.fragment_image_view_detalle_pelicula);
        TextView textViewNombre= view.findViewById(R.id.fragment_detalle_nombre_pelicula);
        TextView textViewSinopsis=view.findViewById(R.id.fragment_sinopsis_peliculas);
        corazonButton=view.findViewById(R.id.corazon_vacio_fav);
        corazonButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!isFav){
                    FirebaseDatabase.getInstance().getReference()
                            .child(FirebaseAuth.getInstance().getCurrentUser().getUid())
                            .child("Peliculas Favoritas")
                            .child(peliculaSeleccionada.getNombre_pelicula())
                            .setValue(peliculaSeleccionada);
                    corazonButton.setImageResource(R.drawable.favorite_full);
                    isFav = true;
                }else {
                    isFav = false;
                    FirebaseDatabase.getInstance().getReference()
                            .child(FirebaseAuth.getInstance().getCurrentUser().getUid())
                            .child("Peliculas Favoritas")
                            .child(peliculaSeleccionada.getNombre_pelicula()).removeValue();
                    corazonButton.setImageResource(R.drawable.favorite_empty);
                }

            }
        });


        Bundle bundle= getArguments();

        final Pelicula unaPelicula= (Pelicula) bundle.getSerializable(CLAVE_PELICULA);

        Glide.with(getContext()).load("https://image.tmdb.org/t/p/w500/"+unaPelicula.getImagen()).into(imageViewImagen);
        ponerListenerAFirebase(new ResultListener<Boolean>() {
            @Override
            public void finish(Boolean result) {
                isFav = result;
            }
        });
        textViewNombre.setText(unaPelicula.getNombre_pelicula());
        textViewSinopsis.setText(unaPelicula.getSinopsis());

        Button button = view.findViewById(R.id.boton_trailer);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getContext(),TrailerActivity.class);
                Bundle otroBundle = new Bundle();
                otroBundle.putString(TrailerActivity.KEY_ID_PELICULA, unaPelicula.getId());
                intent.putExtras(otroBundle);
                startActivity(intent);
            }
        });


        return view;
    }


    private void ponerListenerAFirebase(final ResultListener<Boolean> listener){
        FirebaseDatabase.getInstance().getReference()
                .child(FirebaseAuth.getInstance().getCurrentUser().getUid())
                .child("Peliculas Favoritas")
                .child(peliculaSeleccionada.getNombre_pelicula())
                .addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        if(dataSnapshot.exists()){
                            listener.finish(true);
                            corazonButton.setImageResource(R.drawable.favorite_full);
                        }else{
                            listener.finish(false);
                            corazonButton.setImageResource(R.drawable.favorite_empty);
                        }
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {

                    }
                });


    }


}
