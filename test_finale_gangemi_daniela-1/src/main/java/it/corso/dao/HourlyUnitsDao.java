package it.corso.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import it.corso.model.HourlyUnits;

public interface HourlyUnitsDao extends JpaRepository<HourlyUnits, Integer> {

}
