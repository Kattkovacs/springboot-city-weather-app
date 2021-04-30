package com.kinepict.springbootcityweatherapp.model;

import com.fasterxml.jackson.annotation.JsonProperty;


public class WeatherInCity {
    @JsonProperty("temp")
    private Object degree;

    public Object getDegree() {
        return degree;
    }
}
