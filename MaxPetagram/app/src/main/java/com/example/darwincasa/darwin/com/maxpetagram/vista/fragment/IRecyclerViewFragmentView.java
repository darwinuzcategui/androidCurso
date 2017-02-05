package com.example.darwincasa.darwin.com.maxpetagram.vista.fragment;

/**
 * Created by casa on 01/02/2017.
 */

import com.example.darwincasa.darwin.com.maxpetagram.adapter.ContactoAdaptador;
import com.example.darwincasa.darwin.com.maxpetagram.model.Contacto;

import java.util.ArrayList;

/**
 * Created by anahisalgado on 21/04/16.
 */
public interface IRecyclerViewFragmentView {

    public void generarLinearLayoutVertical();

    public ContactoAdaptador crearAdaptador(ArrayList<Contacto> contactos);

    public void inicializarAdaptadorRV(ContactoAdaptador adaptador);
}