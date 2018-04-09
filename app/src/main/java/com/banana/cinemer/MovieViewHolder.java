package com.banana.cinemer;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Класс хранит внутренние вьюхи элемента списка.
 */
public class MovieViewHolder extends RecyclerView.ViewHolder {

    TextView titleTextView; // текстовое поле для заголовка фильма
    ImageView posterImageView;

    public MovieViewHolder(View itemView) {
        super(itemView);

        // ищем внутренние вьюхи
        titleTextView = itemView.findViewById(android.R.id.text1);
        assadsadsa
    }

}
