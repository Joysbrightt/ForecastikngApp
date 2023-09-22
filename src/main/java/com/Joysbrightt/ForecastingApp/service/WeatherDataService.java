package com.Joysbrightt.ForecastingApp.service;

import com.Joysbrightt.ForecastingApp.exception.WeatherDataNotFoundException;
import com.Joysbrightt.ForecastingApp.model.WeatherData;

public interface WeatherDataService {

        WeatherData getWeatherByCity(String city) throws WeatherDataNotFoundException;
}
