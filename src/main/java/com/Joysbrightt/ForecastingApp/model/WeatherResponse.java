package com.Joysbrightt.ForecastingApp.model;

import lombok.Getter;
import lombok.Setter;

import java.util.List;
@Setter
@Getter
public class WeatherResponse {

    private  Location location;

    private  WeatherData currentWeather;

    private List<Forecast> forecasts;
}
