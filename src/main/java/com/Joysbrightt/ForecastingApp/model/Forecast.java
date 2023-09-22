package com.Joysbrightt.ForecastingApp.model;

import lombok.Data;

import java.time.LocalDate;

@Data
public class Forecast {

    private LocalDate date;
    private double highTemperature;
    private double lowTemperature;
    private String  condition;
}
