package com.banana.cinemer;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

public class MoviesFragment extends Fragment {

    MovieAdapter adapter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater
            , @Nullable ViewGroup container
            , @Nullable Bundle savedInstanceState) {
        // создаём вьюху
        View view = inflater.inflate(R.layout.fragment_movies, container, false);

        // наполняем содержимым
        // просто сохраняем активность в переменную, чтобы понятно было что активность = контекст
        Context context = getContext();
        // создаём адаптер (передаём ему контект)
        adapter = new MovieAdapter((MainActivity) getActivity());
        // находим RV
        RecyclerView recyclerView = view.findViewById(R.id.recycler_view);
        // присоединяем к нему адаптер
        recyclerView.setAdapter(adapter);
        // говорим, чтобы элементы отображались в виде ЛИНЕЙНОГО списка
        recyclerView.setLayoutManager(new GridLayoutManager(context, 2));

        // возвращаем её
        return view;
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
