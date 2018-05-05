package com.banana.cinemer;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MovieActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie);

        // достаём из интента фильм
        // (так что при запуске этой активности важно положить в интент фильм, иначе упадёт тут)
        final Movie movie = (Movie) getIntent().getSerializableExtra("MOVIE");
        // отображаем название фильма в титле тулбара
        getSupportActionBar().setTitle(movie.title);
    }

}
