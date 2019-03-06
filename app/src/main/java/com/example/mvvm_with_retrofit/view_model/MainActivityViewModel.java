package com.example.mvvm_with_retrofit.view_model;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.MutableLiveData;
import android.support.annotation.NonNull;

import com.example.mvvm_with_retrofit.model.User;
import com.example.mvvm_with_retrofit.model.UserRepository;

import java.util.List;

public class MainActivityViewModel extends AndroidViewModel {

    private UserRepository userRepository;

    public MainActivityViewModel(@NonNull Application application) {
        super(application);
        userRepository = new UserRepository(application);
    }

    public MutableLiveData<List<User>> getAllUsers() {
        return userRepository.getAllUsers();
    }
}
