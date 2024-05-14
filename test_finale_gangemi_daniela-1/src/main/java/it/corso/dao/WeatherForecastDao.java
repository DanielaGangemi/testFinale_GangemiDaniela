package it.corso.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import it.corso.model.WeatherForecast;

public interface WeatherForecastDao extends JpaRepository<WeatherForecast, Integer> {

}
