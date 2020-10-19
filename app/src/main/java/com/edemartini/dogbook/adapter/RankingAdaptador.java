package com.edemartini.dogbook.adapter;


import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.edemartini.dogbook.R;
import com.edemartini.dogbook.pojo.Mascota;

import java.util.ArrayList;

public class RankingAdaptador extends RecyclerView.Adapter<RankingAdaptador.RankingViewHolder> {

    ArrayList<Mascota> mascotas;
    Activity activity;

    public RankingAdaptador(ArrayList<Mascota> mascotas, Activity activity) {
        this.mascotas = mascotas;
        this.activity = activity;
    }

    @NonNull
    @Override
    public RankingViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview_ranking, parent, false);
        return new RankingViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull RankingViewHolder holder, int position) {
        Mascota mascota = mascotas.get(position);
        holder.imgFotoCvRanking.setImageResource(mascota.getFoto());
        holder.tvNombreCvRanking.setText(mascota.getNombre());
        holder.tvLikesCvRanking.setText(Integer.toString(mascota.getLikes()));
    }

    @Override
    public int getItemCount() {
        return mascotas.size();
    }


    public static class RankingViewHolder extends RecyclerView.ViewHolder {

        private ImageView imgFotoCvRanking;
        private TextView tvNombreCvRanking;
        private TextView tvLikesCvRanking;


        public RankingViewHolder(@NonNull View itemView) {
            super(itemView);

            imgFotoCvRanking = (ImageView) itemView.findViewById(R.id.imgFotoCvRanking);
            tvNombreCvRanking = (TextView) itemView.findViewById(R.id.tvNombreCvRanking);
            tvLikesCvRanking = (TextView) itemView.findViewById(R.id.tvLikesCvRanking);
        }
    }

}
