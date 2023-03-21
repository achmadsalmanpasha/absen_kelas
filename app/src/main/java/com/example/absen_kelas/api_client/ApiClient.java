package com.example.absen_kelas.api_client;

import com.example.absen_kelas.service.UserService;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiClient {
    public String BASE_URL = "http://192.168.70.10:8000/api/";

    public Retrofit getService(){
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        return retrofit;
    }

    public static UserService getUserService(){
        UserService userService = new ApiClient().getService().create(UserService.class);

        return userService;
    }
}
