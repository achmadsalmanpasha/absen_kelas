package com.example.absen_kelas.service;

import com.example.absen_kelas.request.UserRequest;
import com.example.absen_kelas.response.UserResponse;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface UserService {
    @POST("login")
    Call<UserResponse> login(@Body UserRequest userRequest);
}
