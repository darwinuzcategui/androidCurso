package com.example.darwincasa.darwin.com.maxpetagram.model;

/**
 * Created by casa on 01/02/2017.
 */
import android.content.ContentValues;
import android.content.Context;
import android.util.Log;


import com.example.darwincasa.darwin.com.maxpetagram.R;
import com.example.darwincasa.darwin.com.maxpetagram.db.BaseDatos;
import  com.example.darwincasa.darwin.com.maxpetagram.db.ConstantesBaseDatos;


import java.io.IOException;
import java.util.ArrayList;


/**
 * Created by anahisalgado on 21/04/16.
 */
public class ConstructorContactos{

    private static final int LIKE = 1;
    private Context context;
    public ConstructorContactos(Context context) {
        this.context = context;
    }

    public ArrayList<Contacto> obtenerDatos() {
        BaseDatos db = new BaseDatos(context);
        insertarTresContactos(db);
        return  db.obtenerTodosLosContactos();
    }



    public void insertarTresContactos(BaseDatos db){
        ContentValues contentValues = new ContentValues();
        contentValues.put(ConstantesBaseDatos.TABLE_CONTACTS_NOMBRE, "Darwin Uzcategui");
        contentValues.put(ConstantesBaseDatos.TABLE_CONTACTS_TELEFONO, "0414.332.1763");
        contentValues.put(ConstantesBaseDatos.TABLE_CONTACTS_EMAIL, "darwin.uzcategui1973@gmail.com");
        contentValues.put(ConstantesBaseDatos.TABLE_CONTACTS_FOTO, R.drawable.candy_icon);

        db.insertarContacto(contentValues);

        contentValues = new ContentValues();
        contentValues.put(ConstantesBaseDatos.TABLE_CONTACTS_NOMBRE, "Pedro Sanchez");
        contentValues.put(ConstantesBaseDatos.TABLE_CONTACTS_TELEFONO, "02125419181");
        contentValues.put(ConstantesBaseDatos.TABLE_CONTACTS_EMAIL, "pedro@gmail.com");
        contentValues.put(ConstantesBaseDatos.TABLE_CONTACTS_FOTO, R.drawable.yammi_banana_icon);

        db.insertarContacto(contentValues);

        contentValues = new ContentValues();
        contentValues.put(ConstantesBaseDatos.TABLE_CONTACTS_NOMBRE, "Yasmin Gomez");
        contentValues.put(ConstantesBaseDatos.TABLE_CONTACTS_TELEFONO, "04167261212");
        contentValues.put(ConstantesBaseDatos.TABLE_CONTACTS_EMAIL, "yasmin@gmail.com");
        contentValues.put(ConstantesBaseDatos.TABLE_CONTACTS_FOTO, R.drawable.shock_rave_bonus_icon);

        db.insertarContacto(contentValues);
    }

    public void darLikeCotnacto(Contacto contacto){
        BaseDatos db = new BaseDatos(context);
        ContentValues contentValues = new ContentValues();
        contentValues.put(ConstantesBaseDatos.TABLE_LIKES_CONTACT_ID_CONTACTO, contacto.getId());
        contentValues.put(ConstantesBaseDatos.TABLE_LIKES_CONTACT_NUMERO_LIKES, LIKE);
        db.insertarLikeContacto(contentValues);
    }

    public int obtenerLikesContacto(Contacto contacto){
        BaseDatos db = new BaseDatos(context);
        return db.obtenerLikesContacto(contacto);
    }


}
