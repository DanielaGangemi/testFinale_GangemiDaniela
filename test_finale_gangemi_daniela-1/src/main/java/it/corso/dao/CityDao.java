package it.corso.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import it.corso.model.City;

public interface CityDao extends JpaRepository<City, Integer> {

}
