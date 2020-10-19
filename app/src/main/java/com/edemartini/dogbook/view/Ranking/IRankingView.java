package com.edemartini.dogbook.view.Ranking;

import com.edemartini.dogbook.adapter.RankingAdaptador;
import com.edemartini.dogbook.pojo.Mascota;

import java.util.ArrayList;

public interface IRankingView {

    public void generarLinearLayoutVertical();
    public RankingAdaptador crearAdaptador(ArrayList<Mascota> mascotas);
    public void inicializarAdaptador(RankingAdaptador adaptador);

}
