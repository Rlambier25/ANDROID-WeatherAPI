package com.example.guest.weatherapi;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.io.IOException;
import java.util.ArrayList;

import butterknife.Bind;
import butterknife.ButterKnife;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;

public class WeatherResultsActivity extends AppCompatActivity {
    //    @Bind(R.id.recyclerView) RecyclerView mRecyclerView;
    @Bind(R.id.listView) ListView mListView;
    public static final String TAG = WeatherResultsActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_weather_results);
        ButterKnife.bind(this);


        Intent intent = getIntent();
        String location = intent.getStringExtra("location");
        getWeather(location);
    }

    private void getWeather(String location) {
        final WeatherService weatherService = new WeatherService();

        weatherService.getWeather(location, new Callback() {

            @Override
            public void onFailure(Call call, IOException e) {
                e.printStackTrace();
            }

            @Override
            public void onResponse(Call call, Response response) {
                forecast = weatherService.processResults(response);

                WeatherResultsActivity.this.runOnUiThread(new Runnable() {
                    @Override
                    public void run() {

                            Log.d(TAG, "Weather: " + forecast.getWeatherMain());
                            Log.d(TAG, "Description: " + forecast.getDescription());
                            Log.d(TAG, "Temperature: " + forecast.getTemp());
                            Log.d(TAG, "City: " + forecast.getCityName());
                        }
                    }
            }
         });
    }
