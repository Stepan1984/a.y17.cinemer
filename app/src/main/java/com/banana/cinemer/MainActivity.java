package com.banana.cinemer;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // запускаем загрузку данных
        Database.load();

        if (savedInstanceState == null) { // если запускаем в первый раз активность,
            // то устанавливаем у неё главный фрагмент в качестве основного
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.fragments_container, new MoviesFragment())
                    .commit();
        }
    }

}
