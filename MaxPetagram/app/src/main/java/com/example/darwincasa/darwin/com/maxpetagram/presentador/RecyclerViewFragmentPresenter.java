package com.example.darwincasa.darwin.com.maxpetagram.presentador;

/**
 * Created by casa on 01/02/2017.
 */
import android.content.Context;
import com.example.darwincasa.darwin.com.maxpetagram.model.ConstructorContactos;
import com.example.darwincasa.darwin.com.maxpetagram.model.Contacto;
import com.example.darwincasa.darwin.com.maxpetagram.vista.fragment.IRecyclerViewFragmentView;
import com.example.darwincasa.darwin.com.maxpetagram.vista.fragment.RecyclerViewFragment;

import java.util.ArrayList;

/**
 * Created by anahisalgado on 21/04/16.
 */
public class RecyclerViewFragmentPresenter implements IRecylerViewFragmentPresenter {

    private IRecyclerViewFragmentView iRecyclerViewFragmentView;
    private Context context;
    private ConstructorContactos constructorContactos;
    private ArrayList<Contacto> contactos;

    public  RecyclerViewFragmentPresenter(IRecyclerViewFragmentView iRecyclerViewFragmentView, Context context) {
        this.iRecyclerViewFragmentView = iRecyclerViewFragmentView;
        this.context = context;
        obtenerContactos();
    }

    @Override
    public void obtenerContactos() {
        constructorContactos = new ConstructorContactos(context);
        contactos = constructorContactos.obtenerDatos();
        mostrarContactosRV();
    }


    @Override
    public void mostrarContactosRV() {
        iRecyclerViewFragmentView.inicializarAdaptadorRV(iRecyclerViewFragmentView.crearAdaptador(contactos));
        iRecyclerViewFragmentView.generarLinearLayoutVertical();
    }
}