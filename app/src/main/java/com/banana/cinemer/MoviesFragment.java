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

public class MoviesFragment extends Fragment {

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
        MovieAdapter adapter = new MovieAdapter(context);
        // находим RV
        RecyclerView recyclerView = view.findViewById(R.id.recycler_view);
        // присоединяем к нему адаптер
        recyclerView.setAdapter(adapter);
        // говорим, чтобы элементы отображались в виде ЛИНЕЙНОГО списка
        recyclerView.setLayoutManager(new GridLayoutManager(context, 2));

        // возвращаем её
        return view;
    }

}
