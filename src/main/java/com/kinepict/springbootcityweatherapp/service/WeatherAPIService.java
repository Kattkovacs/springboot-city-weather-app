package com.kinepict.springbootcityweatherapp.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
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

    @Value("${API_KEY}")
    private String API_KEY;

    public void getWeatherByCity(String city){
        String url = String.format(baseURL.concat("%s").concat("&appid=%s").concat("&units=metric"), city, API_KEY);
        RestTemplate template = new RestTemplate();

        try {
            ResponseEntity<String> weatherResponseEntity =
                    template.exchange(url, HttpMethod.GET, null, String.class);
            log.info("Application waits for response data.");
            ObjectNode node = new ObjectMapper().readValue(weatherResponseEntity.getBody(), ObjectNode.class);
            if (node.has("list")) {
                log.info("The current weather in: " + city + " city is " + node.get("list").get(0).get("main").get("temp") + " degree(s) in Celsius!");
            }
        } catch (Exception e ){ log.error("Unknown error: "); e.printStackTrace(); }

    }

}
