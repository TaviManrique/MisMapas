package com.manriquetavi.mismapas;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private RecyclerView rvCardView;
    private ArrayList<Integer> imageViews;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        rvCardView = (RecyclerView) findViewById(R.id.rvCardView);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(this, 2);
        rvCardView.setLayoutManager(gridLayoutManager);
        inicializarListaImages();
        inicializarAdaptador();
    }

    private void inicializarAdaptador() {
        CardViewAdaptador adaptador = new CardViewAdaptador(imageViews, this);
        rvCardView.setAdapter(adaptador);
    }

    private void inicializarListaImages() {
        imageViews = new ArrayList<Integer>();
        imageViews.add(R.drawable.ic_coffe);
        imageViews.add(R.drawable.ic_park);
        imageViews.add(R.drawable.ic_bank);
        imageViews.add(R.drawable.ic_icecream);

    }
}