package com.devsuperior.bds04.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.devsuperior.bds04.entities.City;

public interface CityReposiroty extends JpaRepository<City, Long> {

}
