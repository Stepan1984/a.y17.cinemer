package com.banana.cinemer;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.Random;

public class MovieAdapter extends RecyclerView.Adapter<MovieViewHolder> {

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
    public void onBindViewHolder(@NonNull MovieViewHolder holder, final int position) {
        // получаем заголовок фильма
        String title = Database.MOVIES[position].title;
        // и записываем его в текстовое поле
        holder.titleTextView.setText(title);
        // и постер ещё в ImageView для постера
        // TODO испльзовать MOVIES_POSTER и Glide для загрузки картинок
        final int randomColor = 0xFF000000 + (int) (Math.random() * 0x01000000);
        holder.posterImageView.setBackgroundColor(randomColor);

        // подписываюсь на клики по элементам списка
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // получаю выбранный фильм
                Movie movie = Database.CARDS[position];
                // передаю его в метод startMovieActivity
                startMovieActivity(movie);
            }
        });
    }

    /**
     * Возвращает количество элементов.
     */
    @Override
    public int getItemCount() {
        return Database.MOVIES.length;
    }

    /**
     * Метод стартует активность с подробной информацией по фильму movie.
     */
    private void startMovieActivity(Movie movie) {
        Intent intent = new Intent(context, MovieActivity.class);
        intent.putExtra("CARD", movie);
        context.startActivity(intent);
    }

}
