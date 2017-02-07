package com.example.darwincasa.darwin.com.maxpetagram.presentador;

/**
 * Created by casa on 01/02/2017.
 */
import android.content.Context;
import android.util.Log;
import android.widget.Toast;

import com.example.darwincasa.darwin.com.maxpetagram.model.ConstructorContactos;
import com.example.darwincasa.darwin.com.maxpetagram.model.Contacto;
import com.example.darwincasa.darwin.com.maxpetagram.restApi.EndpointsApi;
import com.example.darwincasa.darwin.com.maxpetagram.restApi.adaptadorApi.RestApiAdapter;
import com.example.darwincasa.darwin.com.maxpetagram.restApi.modeloRestApi.ContatnctoReponse_Respuesta;
import com.example.darwincasa.darwin.com.maxpetagram.vista.fragment.IRecyclerViewFragmentView;
import com.example.darwincasa.darwin.com.maxpetagram.vista.fragment.RecyclerViewFragment;
import com.google.gson.Gson;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

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
        //obtenerContactos();
        obtenerMedioRecintes();
    }

    @Override
    public void obtenerContactos() {
        constructorContactos = new ConstructorContactos(context);
        contactos = constructorContactos.obtenerDatos();
        mostrarContactosRV();
    }

    @Override
    public void obtenerMedioRecintes() {

        RestApiAdapter restApiAdapter = new RestApiAdapter();
        Gson  gsonMediaRecient =  restApiAdapter.CostruyenGsonDeserializadorMediaRecent();
        EndpointsApi endpointsApi = restApiAdapter.establecerConexionRestApiInstagram(gsonMediaRecient);
        //en esta dos linea esta ejecuntado la llamada al servidor y ubicando al enpoint y luego ejecutar la llamada get recentmedia

        // y luego la almacena mos en la clase call en la respuesta contatoc reenso endpointsApi.getRecienteMedia();
        //en linea  ejecuntado la getRecentMedia()
        Call<ContatnctoReponse_Respuesta> contatnctoReponse_respuestaCall = endpointsApi.getRecienteMedia();
        contatnctoReponse_respuestaCall.enqueue(new Callback<ContatnctoReponse_Respuesta>() {
            @Override
            public void onResponse(Call<ContatnctoReponse_Respuesta> call, Response<ContatnctoReponse_Respuesta> response) {
                ContatnctoReponse_Respuesta contatnctoReponseRespuesta = response.body();
                contactos = contatnctoReponseRespuesta.getContactos();
                mostrarContactosRV();


            }

            @Override
            public void onFailure(Call<ContatnctoReponse_Respuesta> call, Throwable t) {

                Toast.makeText(context," algo paso en  la conexion ! Intente de Nuevo", Toast.LENGTH_LONG).show();
                Log.e("fallo la conexion ",t.toString());

            }
        });




    }


    @Override
    public void mostrarContactosRV() {
        iRecyclerViewFragmentView.inicializarAdaptadorRV(iRecyclerViewFragmentView.crearAdaptador(contactos));
        iRecyclerViewFragmentView.generarGrirdLayout();
    }
}