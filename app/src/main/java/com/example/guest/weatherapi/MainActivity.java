package com.example.guest.weatherapi;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.content.Intent;
import android.graphics.Typeface;
import android.widget.Button;
import android.widget.EditText;

import com.example.guest.weatherapi.R;

import butterknife.Bind;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    @Bind(R.id.getWeatherButton) Button mGetWeatherButton;
    @Bind(R.id.userZip) EditText mUserZip;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);


        mGetWeatherButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if(v == mGetWeatherButton) {
            String location = mUserZip.getText().toString();
            Intent intent = new Intent(MainActivity.this, WeatherResultsActivity.class);
            intent.putExtra("location", location);
            startActivity(intent);
        }
    }
}
