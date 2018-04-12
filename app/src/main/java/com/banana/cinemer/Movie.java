package com.banana.cinemer;

import java.io.Serializable;

/**
 * Класс для фильма.
 */
public class Movie implements Serializable {

    public String title; // заголовок фильма
    public String posterPath; // относительный адрес картинки с постером

    public Movie(String title, String posterPath) {
        this.title = title;
        this.posterPath = posterPath;
    }

}
