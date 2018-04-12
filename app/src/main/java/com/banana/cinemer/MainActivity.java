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

        // просто сохраняем активность в переменную, чтобы понятно было что активность = контекст
        Context context = MainActivity.this;
        // создаём адаптер (передаём ему контект)
        MovieAdapter adapter = new MovieAdapter(context);
        // находим RV
        RecyclerView recyclerView = findViewById(R.id.recycler_view);
        // присоединяем к нему адаптер
        recyclerView.setAdapter(adapter);
        // говорим, чтобы элементы отображались в виде ЛИНЕЙНОГО списка
        recyclerView.setLayoutManager(new LinearLayoutManager(context));
    }

}
