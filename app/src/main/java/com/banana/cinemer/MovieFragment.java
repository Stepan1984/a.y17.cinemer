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

public class MovieFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater
            , @Nullable ViewGroup container
            , @Nullable Bundle savedInstanceState) {
        // создаём вьюху
        View view = inflater.inflate(R.layout.fragment_movie, container, false);

        // потом нужно будет настроить

        // возвращаем её
        return view;
    }

}
