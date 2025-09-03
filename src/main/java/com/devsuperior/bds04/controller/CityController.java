package com.devsuperior.bds04.controller;

import java.net.URI;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.devsuperior.bds04.dto.CityDTO;
import com.devsuperior.bds04.services.CityService;

import jakarta.validation.Valid;

@RestController
@RequestMapping(value = "/cities")
public class CityController {

  private final CityService service;

  public CityController(CityService service) {
    this.service = service;
  }

  @GetMapping
  public ResponseEntity<List<CityDTO>> findAll() {
    return ResponseEntity.ok().body(service.findAll());
  }

  @PreAuthorize("hasAnyRole('ROLE_ADMIN')")
  @PostMapping
  public ResponseEntity<CityDTO> save(@Valid @RequestBody CityDTO dto) {

    dto = service.save(dto);

    URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
        .buildAndExpand(dto.getId()).toUri();

    return ResponseEntity.created(uri).body(dto);
  }

}
