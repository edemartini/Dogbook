package com.edemartini.dogbook.view.MainActivity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import com.edemartini.dogbook.R;
import com.edemartini.dogbook.presenter.IPresenter;
import com.edemartini.dogbook.presenter.MainActivityPresenter;
import com.edemartini.dogbook.view.Ranking.Ranking;
import com.edemartini.dogbook.adapter.MascotaAdaptador;
import com.edemartini.dogbook.pojo.Mascota;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements IMainActivityView {

    private ArrayList<Mascota> mascotas;
    private RecyclerView rvMascotas;
    private IPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar miActionBar = (Toolbar) findViewById(R.id.miActionBar);
        setSupportActionBar(miActionBar);

        rvMascotas = (RecyclerView) findViewById(R.id.rvMascotas);

        presenter = new MainActivityPresenter(this, this);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_opciones, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        Intent intent = new Intent(this, Ranking.class);
        startActivity(intent);
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void generarLinearLayoutVertical() {
        LinearLayoutManager llm = new LinearLayoutManager(this);
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        rvMascotas.setLayoutManager(llm);
    }

    @Override
    public MascotaAdaptador crearAdaptador(ArrayList<Mascota> mascotas) {
        MascotaAdaptador adaptador = new MascotaAdaptador(mascotas, this);
        return adaptador;
    }

    @Override
    public void inicializarAdaptador(MascotaAdaptador adaptador) {
        rvMascotas.setAdapter(adaptador);
    }

}