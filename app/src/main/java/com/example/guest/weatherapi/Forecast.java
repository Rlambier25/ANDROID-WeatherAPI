package com.example.guest.weatherapi;

public class Forecast {
    private String mWeatherDescription;
    private String mWeatherMain;
    private int mTemp;
    private String mCityName;

    public Forecast(String main, String description, int temp, String city) {
        this.mWeatherDescription = description;
        this.mWeatherMain = main;
        this.mTemp = temp;
        this.mCityName = city;
    }

    public String getDescription() {
        return mWeatherDescription;
    }

    public String getWeatherMain() {
        return mWeatherMain;
    }

    public Integer getTemp() {
        return mTemp;
    }

    public String getCityName() {
        return mCityName;
    }
}
