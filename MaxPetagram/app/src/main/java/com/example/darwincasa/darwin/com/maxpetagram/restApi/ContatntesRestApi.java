package com.example.darwincasa.darwin.com.maxpetagram.restApi;

/**
 * Created by casa on 01/02/2017.
 */

public  final class ContatntesRestApi {

    //https://api.instagram.com/v1/
    public  static final String VERSION = "/v1/";
    public  static final String ROOT_URL = "https://api.instagram.com"+ VERSION;
    public  static final String ACCESS_TOKEN = "4537776198.ac3ebd4.b5db4c073b6741d380f5c8ca60d273b6";
    public  static final String KEY_ACCESS_TOKEN = "?access_token=";
    // instaagram de darwin uzcategui public  static final String KEY_GET_RECENT_MEDIA_USUARIO = "users/3264052548/media/recent/";
    public  static final String KEY_GET_RECENT_MEDIA_USUARIO = "users/4537776198/media/recent/"; //Insyagram de max

    public  static final String URL_GET_RECENT_MEDIA_USUARIO = KEY_GET_RECENT_MEDIA_USUARIO + KEY_ACCESS_TOKEN + ACCESS_TOKEN ;



    //CONTRUIR ESTA CADENA QUE DEVUELVE LA FOTO RECIENTES
    // https://api.instagram.com/v1/users/3264052548/media/recent/?access_token=4537776198.ac3ebd4.b5db4c073b6741d380f5c8ca60d273b6
    //https://api.instagram.com/v1/ RETROFIT LO VAMOS A COLOCAR





}
