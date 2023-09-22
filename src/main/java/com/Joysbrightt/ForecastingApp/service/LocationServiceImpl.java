package com.Joysbrightt.ForecastingApp.service;

import com.Joysbrightt.ForecastingApp.data.Location;

public class LocationServiceImpl implements LocationService{
    @Override
    public Location getLocationByCity(String city) {

        // Implement logic to fetch location data by city from an API or database

        Location location = new Location();
        location.setCity(city);

        return location;
        
    }
}
