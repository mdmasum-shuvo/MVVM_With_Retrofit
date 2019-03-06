package com.example.mvvm_with_retrofit.view;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.mvvm_with_retrofit.R;
import com.example.mvvm_with_retrofit.adapter.UserAdapter;
import com.example.mvvm_with_retrofit.model.User;
import com.example.mvvm_with_retrofit.view_model.MainActivityViewModel;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.recyclerView)
    RecyclerView recyclerView;
    private MainActivityViewModel viewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        init();
        getUsers();
    }

    private void init() {
        viewModel = ViewModelProviders.of(this).get(MainActivityViewModel.class);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

    }

    private void getUsers() {
        viewModel.getAllUsers().observe(MainActivity.this, new Observer<List<User>>() {
            @Override
            public void onChanged(@Nullable List<User> users) {
                recyclerView.setAdapter(new UserAdapter(users, MainActivity.this));
            }
        });
    }
}
