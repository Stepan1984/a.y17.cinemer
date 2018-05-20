package com.banana.cinemer;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

public class MainActivity extends AppCompatActivity {

    MovieAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // запускаем загрузку данных
        Database.load();

        // наполняем содержимым
        // просто сохраняем активность в переменную, чтобы понятно было что активность = контекст
        Context context = this;
        // создаём адаптер (передаём ему контект)
        adapter = new MovieAdapter(this);
        // находим RV
        RecyclerView recyclerView = findViewById(R.id.recycler_view);
        // присоединяем к нему адаптер
        recyclerView.setAdapter(adapter);
        // говорим, чтобы элементы отображались в виде ЛИНЕЙНОГО списка
        recyclerView.setLayoutManager(new GridLayoutManager(context, 2));
    }

    @Override
    public void onStart() {
        super.onStart();
        // регистрируем фрагмент на события EventBus
        EventBus.getDefault().register(this);
    }

    @Override
    public void onStop() {
        super.onStop();
        // отписываем фрагмент от событий EventBus
        EventBus.getDefault().unregister(this);
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onMessageEvent(Database.OnMovieChangedEvent event) {
        // если получили событие изменения базы данных - рассказываем об этом адаптеру,
        // чтобы он обновил список
        adapter.notifyDataSetChanged();
    };

}
