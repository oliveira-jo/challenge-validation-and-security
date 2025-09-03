package com.devsuperior.bds04.services;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.devsuperior.bds04.dto.EventDTO;
import com.devsuperior.bds04.entities.City;
import com.devsuperior.bds04.entities.Event;
import com.devsuperior.bds04.repositories.EventReposiroty;

@Service
public class EventService {

  private final EventReposiroty repository;

  public EventService(EventReposiroty repository) {
    this.repository = repository;
  }

  @Transactional(readOnly = true)
  public Page<EventDTO> findAll(Pageable pageable) {
    Page<Event> list = repository.findAll(pageable);
    return list.map(obj -> new EventDTO(obj));
  }

  @Transactional
  public EventDTO save(EventDTO dto) {

    Event newEvent = new Event();
    newEvent.setName(dto.getName());
    newEvent.setDate(dto.getDate());
    newEvent.setUrl(dto.getUrl());
    newEvent.setCity(new City(dto.getCityId(), null));

    var resp = repository.save(newEvent);

    return new EventDTO(resp);
  }

}
