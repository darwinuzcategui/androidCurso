package com.example.darwincasa.darwin.com.maxpetagram.restApi.adaptadorApi;

import com.example.darwincasa.darwin.com.maxpetagram.restApi.ContatntesRestApi;
import com.example.darwincasa.darwin.com.maxpetagram.restApi.EndpointsApi;
import com.example.darwincasa.darwin.com.maxpetagram.restApi.deserializador.ContactoDeserializador;
import com.example.darwincasa.darwin.com.maxpetagram.restApi.modeloRestApi.ContatnctoReponse_Respuesta;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import retrofit2.CallAdapter;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by casa on 01/02/2017.
 */

public class RestApiAdapter {


    public EndpointsApi establecerConexionRestApiInstagram(Gson gson){

      //deserializo automatico json para poder lerr los datos  .addConverterFactory(GsonConverterFactory.create())   //

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(ContatntesRestApi.ROOT_URL)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();

        return retrofit.create(EndpointsApi.class);// llamar la url de instargram y dejar inicializado el objeto retrofit

    }

    public Gson CostruyenGsonDeserializadorMediaRecent(){
        GsonBuilder gsonBuilder = new GsonBuilder();
        gsonBuilder.registerTypeAdapter(ContatnctoReponse_Respuesta.class,new ContactoDeserializador());
        return  gsonBuilder.create();


    }

}
