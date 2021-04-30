package com.kinepict.springbootcityweatherapp.service;

import com.kinepict.springbootcityweatherapp.model.WeatherInCity;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@Slf4j
public class WeatherAPIService {

    @Value("${baseURL.url}")
    private String baseURL;

    public WeatherInCity getWeatherByCity(String city) {
        RestTemplate template = new RestTemplate();
        log.info("Application waits for response data.");
        ResponseEntity<WeatherInCity> weatherResponseEntity =
                template.exchange(baseURL + city, HttpMethod.GET, null, WeatherInCity.class);
        log.info(String.valueOf(weatherResponseEntity.getBody()));
        System.out.println(weatherResponseEntity.getBody());
        return weatherResponseEntity.getBody();
    }

}
