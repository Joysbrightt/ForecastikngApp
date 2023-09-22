package com.Joysbrightt.ForecastingApp.service;

import com.Joysbrightt.ForecastingApp.exception.WeatherDataNotFoundException;
import com.Joysbrightt.ForecastingApp.exception.WeatherServiceException;
import com.Joysbrightt.ForecastingApp.model.WeatherData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

public class WeatherDataServiceImpl implements WeatherDataService{

    private static  final String API_KEY = "1736c84e37b2443c94613015232009";
    private static  final String WEATHER_API_URL = "https://www.weatherapi.com/";

    @Autowired
    private RestTemplate restTemplate;
    @Override
    public WeatherData getWeatherByCity(String city) throws WeatherDataNotFoundException {
try {
    // Build the API URL with the city and API key
    String apiUrl = WEATHER_API_URL + "?q=" + city + "&appid=" + API_KEY;

    // Make an HTTP GET request to the weather API
    WeatherData weatherData = restTemplate.getForObject(apiUrl, WeatherData.class);

    // Validate the received weather data
    if (weatherData == null) {
        throw new WeatherDataNotFoundException("weather data is null");
    }
    return weatherData;
} catch(HttpClientErrorException weatherClientExcetion){
    throw new WeatherDataNotFoundException("Weather data not found");
}

catch (Exception weatherException){
    // Handle other exception

    throw new WeatherServiceException("An error occurred while fetching weather data.");
}
    }
}
