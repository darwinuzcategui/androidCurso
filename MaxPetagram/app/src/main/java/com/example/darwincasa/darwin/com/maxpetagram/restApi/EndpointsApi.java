package com.example.darwincasa.darwin.com.maxpetagram.restApi;

import com.example.darwincasa.darwin.com.maxpetagram.restApi.modeloRestApi.ContatnctoReponse_Respuesta;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by casa on 01/02/2017.
 */

public interface EndpointsApi {


    @GET(ContatntesRestApi.URL_GET_RECENT_MEDIA_USUARIO)
    Call<ContatnctoReponse_Respuesta> getRecienteMedia();

}
