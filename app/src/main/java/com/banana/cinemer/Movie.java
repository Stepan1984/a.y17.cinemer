package com.banana.cinemer;

import java.io.Serializable;

public class Movie implements Serializable {

    public String title;
    public String posterPath;

    public Movie(String title, String posterPath) {
        this.title = title;
        this.posterPath = posterPath;
    }

}
