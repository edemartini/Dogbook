package com.edemartini.dogbook.view.Ranking;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.edemartini.dogbook.R;
import com.edemartini.dogbook.adapter.RankingAdaptador;
import com.edemartini.dogbook.pojo.Mascota;
import com.edemartini.dogbook.presenter.IPresenter;
import com.edemartini.dogbook.presenter.RankingPresenter;

import java.util.ArrayList;

public class Ranking extends AppCompatActivity implements IRankingView {

    private ArrayList<Mascota> mascotas;
    private RecyclerView rvMascotas;
    private IPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ranking);

        Toolbar miActionBar = (Toolbar) findViewById(R.id.miActionBar);
        setSupportActionBar(miActionBar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        rvMascotas = (RecyclerView) findViewById(R.id.rvRanking);

        presenter = new RankingPresenter(this, this);

    }

    @Override
    public void generarLinearLayoutVertical() {
        LinearLayoutManager llm = new LinearLayoutManager(this);
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        rvMascotas.setLayoutManager(llm);
    }

    @Override
    public RankingAdaptador crearAdaptador(ArrayList<Mascota> mascotas) {
        RankingAdaptador adaptador = new RankingAdaptador(mascotas, this);
        return adaptador;
    }

    @Override
    public void inicializarAdaptador(RankingAdaptador adaptador) {
        rvMascotas.setAdapter(adaptador);
    }
}