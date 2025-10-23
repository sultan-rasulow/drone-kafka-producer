package com.example.drone.infrastructure.service;

import com.example.drone.infrastructure.web.dto.DroneRequest;
import java.util.UUID;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class DroneKafkaProducer {

  private final KafkaTemplate<String, Object> kafkaTemplate;

  @Value("${app.kafka.topic.drones}")
  private String topic;

  public DroneKafkaProducer(KafkaTemplate<String, Object> kafkaTemplate) {
    this.kafkaTemplate = kafkaTemplate;
  }

  public void send(DroneRequest drone) {
    kafkaTemplate.send(topic, UUID.randomUUID().toString(), drone);
  }
}
