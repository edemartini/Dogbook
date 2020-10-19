package com.edemartini.dogbook.presenter;

import android.content.Context;

import com.edemartini.dogbook.db.ConstructorMascotas;
import com.edemartini.dogbook.db.ConstructorRanking;
import com.edemartini.dogbook.pojo.Mascota;
import com.edemartini.dogbook.view.MainActivity.IMainActivityView;
import com.edemartini.dogbook.view.Ranking.IRankingView;

import java.util.ArrayList;

public class RankingPresenter implements IPresenter {

    private IRankingView iRankingView;
    private Context context;
    private ConstructorRanking constructorRanking;
    private ArrayList<Mascota> mascotas;

    public RankingPresenter(IRankingView iRankingView, Context context) {
        this.iRankingView = iRankingView;
        this.context = context;
        obtenerMascotasBaseDatos();
    }

    @Override
    public void obtenerMascotasBaseDatos() {
        constructorRanking = new ConstructorRanking(context);
        mascotas = constructorRanking.obtenerDatos();
        mostrarMascotas();
    }

    @Override
    public void mostrarMascotas() {
        iRankingView.inicializarAdaptador(iRankingView.crearAdaptador(mascotas));
        iRankingView.generarLinearLayoutVertical();
    }
}
