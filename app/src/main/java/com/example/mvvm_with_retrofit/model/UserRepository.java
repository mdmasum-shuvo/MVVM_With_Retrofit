package com.example.mvvm_with_retrofit.model;

import android.app.Application;
import android.arch.lifecycle.MutableLiveData;
import android.widget.Toast;

import com.example.mvvm_with_retrofit.api.ApiService;
import com.example.mvvm_with_retrofit.api.ApiUtils;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class UserRepository {

    private Application application;
    private MutableLiveData<List<User>> users;

    public UserRepository(Application application) {
        this.application = application;
    }


    public MutableLiveData<List<User>> getAllUsers() {

        if (users == null) {
            users = new MutableLiveData<>();
        }

        ApiService apiService = ApiUtils.getService();

        Call<List<User>> call = apiService.getAllUsers();

        call.enqueue(new Callback<List<User>>() {
            @Override
            public void onResponse(Call<List<User>> call, Response<List<User>> response) {

                if (response.isSuccessful()) {
                    users.setValue(response.body());
                } else {
                    Toast.makeText(application, "No data found", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<List<User>> call, Throwable t) {

                Toast.makeText(application, "Something went wrong", Toast.LENGTH_SHORT).show();
            }
        });

        return users;
    }

}
