package com.banana.cinemer;

import android.content.Context;
import android.graphics.Color;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.Random;

public class MovieAdapter extends RecyclerView.Adapter<MovieViewHolder> {

    static final String[] MOVIES_TITLES = new String[]{"Coco", "Star Wars: The Last Jedi", "Ready Player One", "Black Panther"};
    static final String[] MOVIES_POSTERS = new String[]{"/eKi8dIrr8voobbaGzDpe8w0PVbC.jpg", "/kOVEVeg59E0wsnXmF9nrh6OmWII.jpg", "/pU1ULUq8D3iRxl1fdX2lZIzdHuI.jpg", "/uxzzxijgPIY7slzFvMotPv8wjKA.jpg"};

    Context context;

    public MovieAdapter(Context context) {
        this.context = context;
    }

    /**
     * Метод по запросу от RecyclerView создаёт вьюхи для элементов списка.
     */
    @NonNull
    @Override
    public MovieViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // создаём создавалку вьюшек
        LayoutInflater layoutInflater = LayoutInflater.from(context);
        // создаём вьюшку (пока простую, с одним текстовым полем)
        // false означает, что она просто создаётся, но не добавляет к parent
        View view = layoutInflater.inflate(R.layout.layout_movie_item, parent, false);
        // создаём для этой вьюшки ViewHolder
        MovieViewHolder viewHolder = new MovieViewHolder(view);
        // возвращаем его
        return viewHolder;
    }

    /**
     * Метод заполняет элемент списка (holder) фильмом, стоящим на позиции (position).
     */
    @Override
    public void onBindViewHolder(@NonNull MovieViewHolder holder, int position) {
        // получаем заголовок фильма
        String title = MOVIES_TITLES[position];
        // и записываем его в текстовое поле
        holder.titleTextView.setText(title);
        // TODO испльзовать MOVIES_POSTER и Glide для загрузки картинок
    }

    /**
     * Возвращает количество элементов.
     */
    @Override
    public int getItemCount() {
        return MOVIES_TITLES.length;
    }

}
