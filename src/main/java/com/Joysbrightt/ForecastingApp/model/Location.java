package com.Joysbrightt.ForecastingApp.model;


import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class Location {

    private String city;
    private String country;
    private double latitude;
    private double longitude;
}
