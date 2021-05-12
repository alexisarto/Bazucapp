package com.example.digital.proyectogrupal.view;

import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;

import com.example.digital.proyectogrupal.model.pojo.Pelicula;
import com.example.digital.proyectogrupal.R;
import com.facebook.login.LoginManager;

public class MainActivity extends AppCompatActivity implements FragmentPeliculas.ListenerFragmentPelicula, FragmentCategoriasFavoritas.ListenerFragmentCategoria,SearchFragment.ListenerSearchFragment {



    private  static final String FRAGMENT_CATEGORIA_FAVORITAS = "fragment_categoria_favorita";
    private  static final String FRAGMENT_DETALLE = "fragment_detalle";
    private  static final String FRAGMENT_PELICULAS = "fragment_peliculas";
    private  static final String FRAGMENT_SEARCHVIEW = "fragment_search";


    private  DrawerLayout drawerLayout;
    private  NavigationView navigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        pegarFragment(new FragmentPeliculas(), FRAGMENT_PELICULAS);

        drawerLayout = findViewById(R.id.drawer_layout);
        navigationView = findViewById(R.id.navigation_view_main);

        navigationView.setNavigationItemSelectedListener(new ListenerMenu());




    }


    public void pegarFragment(Fragment fragment,String tag){
        FragmentManager fragmentManager= getSupportFragmentManager();
        FragmentTransaction fragmentTransaction= fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.contenedor_fragments,fragment,tag);

        if (tag.equals(FRAGMENT_DETALLE)){
            fragmentTransaction.addToBackStack(null);
        }
        fragmentTransaction.commit();
    }



    public void informarCategoriaSeleccionada() {
        pegarFragment(new FragmentPeliculas(), FRAGMENT_PELICULAS);
    }

    @Override
    public void informarPeliculaSeleccionada(Pelicula peliculaSeleccionada) {
        FragmentDetallePelicula fragmentDetallePelicula=new FragmentDetallePelicula();
        Bundle bundle = new Bundle();
        bundle.putSerializable(FragmentDetallePelicula.CLAVE_PELICULA,peliculaSeleccionada);
        fragmentDetallePelicula.setArguments(bundle);
        pegarFragment(fragmentDetallePelicula,FRAGMENT_DETALLE);


    }

    @Override
    public void abrirPelicula(Pelicula peliculaSeleccionada) {
        FragmentDetallePelicula fragmentDetallePelicula = new FragmentDetallePelicula();
        Bundle bundle = new Bundle();
        bundle.putSerializable(FragmentDetallePelicula.CLAVE_PELICULA,peliculaSeleccionada);
        fragmentDetallePelicula.setArguments(bundle);
        pegarFragment(fragmentDetallePelicula,FRAGMENT_DETALLE);
    }


    private class ListenerMenu implements NavigationView.OnNavigationItemSelectedListener{


        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            selectedMenuItem(item);
            selectedMenuItem2(item);
            selectedMenuItem3(item);
            drawerLayout.closeDrawers();

            return true;
        }
    }

    private void selectedMenuItem (MenuItem item){
        if (item.getItemId() == R.id.navButtonCategoriasFavoritas){
            pegarFragment(new FragmentCategoriasFavoritas(), FRAGMENT_CATEGORIA_FAVORITAS);

        }
    }
    private void selectedMenuItem2(MenuItem item){
        if (item.getItemId()==R.id.navButtonSearchView){
            pegarFragment(new SearchFragment(),FRAGMENT_SEARCHVIEW);
        }
    }

    private void selectedMenuItem3 (MenuItem item) {
        if (item.getItemId() == R.id.navButtonLogOut) {
            LoginManager.getInstance().logOut();
        }
    }





}
