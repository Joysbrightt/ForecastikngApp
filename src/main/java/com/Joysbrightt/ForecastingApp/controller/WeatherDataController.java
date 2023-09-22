package com.Joysbrightt.ForecastingApp.controller;

import com.Joysbrightt.ForecastingApp.model.WeatherData;
import com.Joysbrightt.ForecastingApp.service.WeatherDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping
public class WeatherDataController {

    @Autowired
    private WeatherDataService weatherDataService;

    @GetMapping("/weather")
    public String getWeather(@RequestParam String city, Model model){

        try{
            // Retrieve weather data for the specified city

            WeatherData weatherData = weatherDataService.getWeatherByCity(city);

            // Add weather data to the model for rendering in the view
            model.addAttribute("weatherData", weatherData);

            // Return the name of the Thymeleaf view template for rendering
            return "weather-view";
        } catch (Exception exception){
            // Handle errors (e.g., city not found, API request failed)

            model.addAttribute("error", "Weather data no available for the specified city.");
            return  "error-view"; // You should create an error view for displaying error messages
        }

    }
}
