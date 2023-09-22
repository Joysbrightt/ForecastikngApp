package com.Joysbrightt.ForecastingApp.controller;

import com.Joysbrightt.ForecastingApp.data.Location;
import com.Joysbrightt.ForecastingApp.exception.WeatherDataNotFoundException;
import com.Joysbrightt.ForecastingApp.model.WeatherData;
import com.Joysbrightt.ForecastingApp.service.LocationService;
import com.Joysbrightt.ForecastingApp.service.WeatherDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping
public class LocationController {

    @Autowired
    private LocationService locationService;

    @Autowired
    private WeatherDataService weatherDataService;


    @GetMapping("/weather")
    public String getWeather(@RequestParam String city, Model model){
        try {
            Location location = locationService.getLocationByCity(city);

            WeatherData weatherByCity = weatherDataService.getWeatherByCity(city);

            model.addAttribute("location", location);
            model.addAttribute("weatherData", weatherByCity);

            return  "weather-view";
        } catch (WeatherDataNotFoundException e) {
            throw new RuntimeException(e);
        }
        catch (Exception locationException){
            model.addAttribute("error", "Weather data not available for the specified locaion.");
        return "error-view";
        }



    }
}
