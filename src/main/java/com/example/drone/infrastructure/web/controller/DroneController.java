package com.example.drone.infrastructure.web.controller;

import com.example.drone.infrastructure.service.DroneKafkaProducer;
import com.example.drone.infrastructure.web.dto.DroneRequest;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/drones")
public class DroneController {

  private final DroneKafkaProducer kafkaProducer;

  public DroneController(DroneKafkaProducer kafkaProducer) {
    this.kafkaProducer = kafkaProducer;
  }

  @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<Void> receiveDrone(@RequestBody @Validated DroneRequest request) {
    kafkaProducer.send(request);
    return ResponseEntity.accepted().build();
  }
}
