package com.banana.cinemer;

import java.util.ArrayList;
import java.util.List;

/**
 * Класс для хранения данных.
 */
public class Database {

    public static final String DATA_URL = "http://api.themoviedb.org/3/movie/popular?api_key=795d87bfa31bd215fc78ae4423e39543";
    public static final List<Movie> MOVIES = new ArrayList<>();

    public static void load() {
        // TODO в понедельник
    }

//    // временная переменная для хранения тестовых данных
//    public static final Movie[] MOVIES = {
//            new Movie("Coco", "/eKi8dIrr8voobbaGzDpe8w0PVbC.jpg")
//            , new Movie("Star Wars: The Last Jedi", "/kOVEVeg59E0wsnXmF9nrh6OmWII.jpg")
//            , new Movie("Ready Player One", "/pU1ULUq8D3iRxl1fdX2lZIzdHuI.jpg")
//            , new Movie("Black Panther", "/uxzzxijgPIY7slzFvMotPv8wjKA.jpg")
//            , new Movie("Coco", "/eKi8dIrr8voobbaGzDpe8w0PVbC.jpg")
//            , new Movie("Star Wars: The Last Jedi", "/kOVEVeg59E0wsnXmF9nrh6OmWII.jpg")
//            , new Movie("Ready Player One", "/pU1ULUq8D3iRxl1fdX2lZIzdHuI.jpg")
//            , new Movie("Black Panther", "/uxzzxijgPIY7slzFvMotPv8wjKA.jpg")
//            , new Movie("Coco", "/eKi8dIrr8voobbaGzDpe8w0PVbC.jpg")
//            , new Movie("Star Wars: The Last Jedi", "/kOVEVeg59E0wsnXmF9nrh6OmWII.jpg")
//            , new Movie("Ready Player One", "/pU1ULUq8D3iRxl1fdX2lZIzdHuI.jpg")
//            , new Movie("Black Panther", "/uxzzxijgPIY7slzFvMotPv8wjKA.jpg")
//    };

}
