package com.edemartini.dogbook.presenter;

import android.content.Context;

import com.edemartini.dogbook.db.ConstructorMascotas;
import com.edemartini.dogbook.pojo.Mascota;
import com.edemartini.dogbook.view.MainActivity.IMainActivityView;

import java.util.ArrayList;

public class MainActivityPresenter implements IPresenter {

    private IMainActivityView iMainActivityView;
    private Context context;
    private ConstructorMascotas constructorMascotas;
    private ArrayList<Mascota> mascotas;

    public MainActivityPresenter(IMainActivityView iMainActivityView, Context context) {
        this.iMainActivityView = iMainActivityView;
        this.context = context;
        obtenerMascotasBaseDatos();
    }


    @Override
    public void obtenerMascotasBaseDatos() {
        constructorMascotas = new ConstructorMascotas(context);
        mascotas = constructorMascotas.obtenerDatos();
        mostrarMascotas();
    }

    @Override
    public void mostrarMascotas() {
        iMainActivityView.inicializarAdaptador(iMainActivityView.crearAdaptador(mascotas));
        iMainActivityView.generarLinearLayoutVertical();
    }
}
