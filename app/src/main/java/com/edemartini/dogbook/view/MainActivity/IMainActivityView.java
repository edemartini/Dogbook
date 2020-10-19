package com.edemartini.dogbook.view.MainActivity;

import com.edemartini.dogbook.adapter.MascotaAdaptador;
import com.edemartini.dogbook.pojo.Mascota;

import java.util.ArrayList;

public interface IMainActivityView {

    public void generarLinearLayoutVertical();
    public MascotaAdaptador crearAdaptador(ArrayList<Mascota> mascotas);
    public void inicializarAdaptador(MascotaAdaptador adaptador);

}
