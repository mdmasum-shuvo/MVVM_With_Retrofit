package com.example.mvvm_with_retrofit.api;

import com.example.mvvm_with_retrofit.model.User;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiService {

    @GET("users")
    Call<List<User>> getAllUsers();

}
