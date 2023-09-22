package com.Joysbrightt.ForecastingApp.model;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class WeatherData {

//    1736c84e37b2443c94613015232009 - APIKEY

    private double temperature;
    private double humidity;
    private double windspeed;
    private String condition;
    private LocalDateTime timestamp;

}
