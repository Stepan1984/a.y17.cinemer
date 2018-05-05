package com.banana.cinemer;

import android.annotation.SuppressLint;
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

@SuppressLint("ValidFragment")
public class MovieFragment extends Fragment {

    Movie movie; // фильм, который этот фрагмент должен отобразить

    public MovieFragment(Movie movie) {
        this.movie = movie; // сохраняем фильм, чтобы потом его отобразить
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater
            , @Nullable ViewGroup container
            , @Nullable Bundle savedInstanceState) {
        // создаём вьюху
        View view = inflater.inflate(R.layout.fragment_movie, container, false);

        // потом нужно будет настроить;
        // здесь, например, просто меняем титл тулбара на название фильма
        final MainActivity activity = (MainActivity) getActivity();
        activity.getSupportActionBar().setTitle(movie.title);

        // возвращаем её
        return view;
    }

}
