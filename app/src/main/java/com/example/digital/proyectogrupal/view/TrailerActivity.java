package com.example.digital.proyectogrupal.view;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.digital.proyectogrupal.R;
import com.example.digital.proyectogrupal.controller.PelisController;
import com.example.digital.proyectogrupal.model.dao.DAOTrailer;
import com.example.digital.proyectogrupal.model.pojo.TrailerContainer;
import com.example.digital.proyectogrupal.utils.ResultListener;
import com.google.android.youtube.player.YouTubeBaseActivity;
import com.google.android.youtube.player.YouTubeInitializationResult;
import com.google.android.youtube.player.YouTubePlayer;
import com.google.android.youtube.player.YouTubePlayerView;

public class TrailerActivity extends YouTubeBaseActivity {

    private YouTubePlayerView youTubePlayerView;
    private Button button;
    private YouTubePlayer.OnInitializedListener onInitializedListener;
    public static final String KEY_ID_PELICULA = "idPelicula";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_trailer);

        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();
        String idPeli = bundle.getString(KEY_ID_PELICULA);
        button = (Button) findViewById(R.id.bn);
        youTubePlayerView = (YouTubePlayerView) findViewById(R.id.youtube_player_view);

        PelisController pelisController = new PelisController();
        pelisController.getTrailerFromPelicula(new ResultListener<TrailerContainer>() {
            @Override
            public void finish(final TrailerContainer result) {
                onInitializedListener = new YouTubePlayer.OnInitializedListener() {
                    @Override
                    public void onInitializationSuccess(YouTubePlayer.Provider provider, YouTubePlayer youTubePlayer, boolean b) {
                        youTubePlayer.loadVideo(result.getResults().get(0).getKey());

                    }

                    @Override
                    public void onInitializationFailure(YouTubePlayer.Provider provider, YouTubeInitializationResult youTubeInitializationResult) {

                    }
                };
            }
        }, idPeli);

        button.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                youTubePlayerView.initialize(DAOTrailer.API_KEY,onInitializedListener);
            }
        });


    }
}
