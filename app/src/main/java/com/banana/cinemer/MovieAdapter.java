package com.banana.cinemer;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v4.app.FragmentManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class MovieAdapter extends RecyclerView.Adapter<MovieViewHolder> {

    MainActivity activity; // главная активность

    public MovieAdapter(MainActivity activity) {
        this.activity = activity; // сохраняем главную активность (потом нужна будет)
    }

    /**
     * Метод по запросу от RecyclerView создаёт вьюхи для элементов списка.
     */
    @NonNull
    @Override
    public MovieViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // создаём создавалку вьюшек
        LayoutInflater layoutInflater = LayoutInflater.from(activity);
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
        String title = Database.MOVIES.get(position).title;
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
                Movie movie = Database.MOVIES.get(position);
                // передаю его в метод showMovieActivity
                showMovieActivity(movie);
            }
        });
    }

    /**
     * Возвращает количество элементов.
     */
    @Override
    public int getItemCount() {
        return Database.MOVIES.size();
    }

    /**
     * Метод покажет новую активность с подробной информацией по фильму movie.
     */
    private void showMovieActivity(Movie movie) {
        Intent intent = new Intent(activity, MovieActivity.class);
        intent.putExtra("MOVIE", movie);
        activity.startActivity(intent);
    }

}
