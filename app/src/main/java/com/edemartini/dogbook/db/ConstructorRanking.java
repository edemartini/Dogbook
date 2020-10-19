package com.edemartini.dogbook.db;

import android.content.Context;

import com.edemartini.dogbook.R;
import com.edemartini.dogbook.pojo.Mascota;

import java.util.ArrayList;

public class ConstructorRanking {

    private Context context;

    public ConstructorRanking(Context context) {
        this.context = context;
    }

    public ArrayList<Mascota> obtenerDatos() {

        /*
        ArrayList<Mascota> mascotas = new ArrayList<>();
        mascotas.add(new Mascota(R.drawable.alegre, "Alegre", 25));
        mascotas.add(new Mascota(R.drawable.bonita, "Bonita", 20));
        mascotas.add(new Mascota(R.drawable.cazador, "Cazador", 18));
        mascotas.add(new Mascota(R.drawable.guardian, "Guardián", 14));
        mascotas.add(new Mascota(R.drawable.jugueton, "Juguetón", 12));
        return mascotas;
        */

        BaseDatos db = new BaseDatos(context);
        return db.obtenerTopCincoMascotas();

    }

}
