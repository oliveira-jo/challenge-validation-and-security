package com.devsuperior.bds04.controller;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.devsuperior.bds04.dto.EventDTO;
import com.devsuperior.bds04.services.EventService;

import jakarta.validation.Valid;

@RestController
@RequestMapping(value = "/events")
public class EventController {

  private final EventService service;

  public EventController(EventService service) {
    this.service = service;
  }

  @GetMapping
  public ResponseEntity<Page<EventDTO>> findAll(Pageable pageable) {
    return ResponseEntity.ok().body(service.findAll(pageable));
  }

  @PostMapping
  public ResponseEntity<EventDTO> save(@Valid @RequestBody EventDTO dto) {
    return ResponseEntity.ok().body(service.save(dto));
  }

}
