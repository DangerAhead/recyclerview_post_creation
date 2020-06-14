package com.hfad.post_example2;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiClient {
    public static final String API_BASE_URL = "http://a997769b1805.ngrok.io/";

    private static OkHttpClient.Builder httpClient = new OkHttpClient.Builder();
    public static Retrofit retrofit;

    public static Retrofit createService()
    {
        OkHttpClient okHttpClient = new OkHttpClient.Builder().build();
        if(retrofit==null)
        {
            retrofit = new Retrofit.Builder().baseUrl(API_BASE_URL).
                    addConverterFactory(GsonConverterFactory.create()).client(okHttpClient).build();
        }
        return retrofit;

    }





}
