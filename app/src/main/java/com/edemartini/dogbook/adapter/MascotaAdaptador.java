package com.edemartini.dogbook.adapter;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.edemartini.dogbook.R;
import com.edemartini.dogbook.db.ConstructorMascotas;
import com.edemartini.dogbook.pojo.Mascota;

import java.util.ArrayList;

public class MascotaAdaptador extends RecyclerView.Adapter<MascotaAdaptador.MascotaViewHolder> {

    ArrayList<Mascota> mascotas;
    Activity activity;

    public MascotaAdaptador(ArrayList<Mascota> mascotas, Activity activity) {
        this.mascotas = mascotas;
        this.activity = activity;
    }

    @NonNull
    @Override
    public MascotaViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview_mascota, parent, false);
        return new MascotaViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull MascotaViewHolder holder, int position) {

        ConstructorMascotas constructorMascotas = new ConstructorMascotas(activity);

        Mascota mascota = mascotas.get(position);

        holder.tvNombreCvMascota.setText(mascota.getNombre());
        holder.imgFotoCvMascota.setImageResource(mascota.getFoto());
        holder.tvLikesCvMascota.setText(String.valueOf(constructorMascotas.obtenerLikesMascota(mascota)));

        holder.btnLikeCvMascota.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                constructorMascotas.darLikeMascota(mascota);
                holder.tvLikesCvMascota.setText(String.valueOf(constructorMascotas.obtenerLikesMascota(mascota)));
            }
        });
    }

    @Override
    public int getItemCount() {
        return mascotas.size();
    }


    public static class MascotaViewHolder extends RecyclerView.ViewHolder {

        private ImageView imgFotoCvMascota;
        private ImageButton btnLikeCvMascota;
        private TextView tvNombreCvMascota;
        private TextView tvLikesCvMascota;

        public MascotaViewHolder(@NonNull View itemView) {
            super(itemView);

            imgFotoCvMascota = (ImageView) itemView.findViewById(R.id.imgFotoCvMascota);
            btnLikeCvMascota = (ImageButton) itemView.findViewById(R.id.btnLikeCvMascota);
            tvNombreCvMascota = (TextView) itemView.findViewById(R.id.tvNombreCvMascota);
            tvLikesCvMascota = (TextView) itemView.findViewById(R.id.tvLikesCvMascota);
        }
    }

}
