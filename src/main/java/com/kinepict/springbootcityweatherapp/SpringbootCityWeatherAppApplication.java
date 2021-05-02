package com.kinepict.springbootcityweatherapp;

import com.kinepict.springbootcityweatherapp.service.WeatherAPIService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
@Slf4j
public class SpringbootCityWeatherAppApplication implements CommandLineRunner{

	@Autowired
	WeatherAPIService weatherAPIService;

	@Value("${city1}")
	private String city1;
	@Value("${city2}")
	private String city2;
	@Value("${city3}")
	private String city3;

	public static void main(String[] args) {
		SpringApplication.run(SpringbootCityWeatherAppApplication.class, args);
		log.info("Application stopped");
		log.info("========================");
	}

	@Override
	public void run(String... args) throws Exception {
		log.info("CITY WEATHER APPLICATION");
		log.info("========================");
		log.info("Application started");
		if (args.length == 0){
			args = new String[]{city1, city2, city3};
		}
		for (String arg: args) {
			log.info("The name of the city is: " + arg);
			weatherAPIService.getWeatherByCity(arg);
		}
	}
}
