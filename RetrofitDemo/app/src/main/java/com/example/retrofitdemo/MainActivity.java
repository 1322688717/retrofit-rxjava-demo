package com.example.retrofitdemo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private String key = "66d721a1d6024ca8b6c257fcab036de7";
    private String location = "101010100";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        UlitsRetrofit.getNowWeather(key,location);

    }
}