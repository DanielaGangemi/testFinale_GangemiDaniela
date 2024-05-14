package it.corso.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import it.corso.model.Hourly;

public interface HourlyDao extends JpaRepository<Hourly, Integer> {

}
