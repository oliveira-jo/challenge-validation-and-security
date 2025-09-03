package com.devsuperior.bds04.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.devsuperior.bds04.dto.CityDTO;
import com.devsuperior.bds04.entities.City;
import com.devsuperior.bds04.repositories.CityReposiroty;

@Service
public class CityService {

  private final CityReposiroty repository;

  public CityService(CityReposiroty repository) {
    this.repository = repository;
  }

  @Transactional(readOnly = true)
  public List<CityDTO> findAll() {

    List<City> list = repository.findAll();

    return list.stream().map(
        obj -> new CityDTO(obj)).collect(Collectors.toList());
  }

}
