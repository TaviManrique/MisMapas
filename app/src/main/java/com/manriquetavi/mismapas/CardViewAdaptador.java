package com.manriquetavi.mismapas;

import android.app.Activity;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class CardViewAdaptador extends RecyclerView.Adapter<CardViewAdaptador.CardViewViewHolder> {

    ArrayList<Integer> imageViews;
    Activity activity;

    public CardViewAdaptador(ArrayList<Integer> imageViews, Activity activity){
        this.imageViews = imageViews;
        this.activity = activity;
    }
    public CardViewAdaptador.CardViewViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_view, parent, false);
        return new CardViewAdaptador.CardViewViewHolder(v);
    }

    @Override
    public void onBindViewHolder( CardViewAdaptador.CardViewViewHolder holder, int position) {
        final Integer imageView = imageViews.get(position);
        holder.imgLocation.setImageResource(imageView);
        holder.imgLocation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(activity, String.valueOf(position), Toast.LENGTH_SHORT).show();

                Intent intent = new Intent(activity, MapsActivity.class);
                intent.putExtra("position",position);
                activity.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return imageViews.size();
    }

    public static class CardViewViewHolder extends RecyclerView.ViewHolder{
        private ImageView imgLocation;

        public CardViewViewHolder(View itemView){
            super(itemView);
            imgLocation = (ImageView) itemView.findViewById(R.id.imgLocation);
        }
    }
}
