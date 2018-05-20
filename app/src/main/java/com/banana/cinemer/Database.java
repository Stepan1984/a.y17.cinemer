package com.banana.cinemer;

import android.util.Log;

import org.greenrobot.eventbus.EventBus;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Класс для хранения данных.
 */
public class Database {

    // ссылочка, по которой можно получить данные
    public static final String DATA_URL = "http://api.themoviedb.org/3/movie/popular?api_key=795d87bfa31bd215fc78ae4423e39543";
    // массив (список) с данными
    public static final List<Movie> MOVIES = new ArrayList<>();

    /**
     * Запуск операции получения данных из интернета и заполнения ими базы данных.
     */
    public static void load() {
        // создаём запрос
        Request request = new Request.Builder()
                .url(DATA_URL) // устанавливаем ссылку
                .build();
        // создаём клиент, отправляем запрос и подписываемся на ответ
        OkHttpClient client = new OkHttpClient();
        client.newCall(request).enqueue(new Callback() {

            @Override
            public void onFailure(Call call, IOException e) {
                // этот метод запускается, если есть ошибка
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                String data = response.body().string(); // получаем строку с данными
                parse(data); // парсим их
            }

        });
    }

    /**
     * Запуск операции парсинга строки data (превращения из строки в объекты типа Movie).
     */
    public static void parse(String data) {
        try {
            // получаем из строки data объект класса JSONObject, упрощающий парсинг
            JSONObject object = new JSONObject(data);
            // получаем массив c информацией по фильмам по ключу `results`
            JSONArray results = object.getJSONArray("results");
            // запускаем цикл
            for (int i = 0; i < results.length(); ++i) {
                // получаем информацию по фильму, который стоит на позиции i
                JSONObject film = results.getJSONObject(i);
                String title = film.getString("title"); // получаем название
                String posterPath = film.getString("poster_path"); // и постер
                Movie movie = new Movie(title, posterPath); // создаём фильм по названию и постеру
                MOVIES.add(movie); // сохраняем = добавляем в MOVIES
            }
            EventBus.getDefault().post(new OnMovieChangedEvent());
        } catch (JSONException e) {
            Log.e("Database", "Ошибка: ", e);
        }
    }

    /**
     * Класс события внесения в базу данных изменений.
     */
    public static class OnMovieChangedEvent {}

}
