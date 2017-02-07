package com.example.darwincasa.darwin.com.maxpetagram.restApi.modeloRestApi;

import com.example.darwincasa.darwin.com.maxpetagram.model.Contacto;

import java.util.ArrayList;

/**
 * Created by casa on 01/02/2017.
 */

public class ContatnctoReponse_Respuesta {
    ArrayList<Contacto> contactos;

    public ArrayList<Contacto> getContactos() {
        return contactos;
    }

    public void setContactos(ArrayList<Contacto> contactos) {
        this.contactos = contactos;
    }
}
