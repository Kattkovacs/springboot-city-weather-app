package com.kinepict.springbootcityweatherapp;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringbootCityWeatherAppApplication {
	private static Logger logger = LoggerFactory.getLogger(SpringbootCityWeatherAppApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(SpringbootCityWeatherAppApplication.class, args);
			logger.debug("Debug log message");
			logger.info("Application started");
			logger.error("Error log message");
	}

}
