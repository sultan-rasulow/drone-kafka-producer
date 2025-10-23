package com.example.drone.infrastructure.config;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;

@Configuration
public class KafkaTopicConfiguration {

  @Value("${app.kafka.topic.drones}")
  private String droneTopic;

  @Value("${app.kafka.topic.partitions}")
  private int partitions;

  @Value("${app.kafka.topic.replication-factor}")
  private int replicationFactor;

  @Bean
  public NewTopic droneTopic() {
    return TopicBuilder.name(droneTopic)
        .partitions(partitions)
        .replicas(replicationFactor)
        .config("retention.ms", "86400000")
        .config("segment.ms", "3600000")
        .config("compression.type", "snappy")
        .build();
  }
}
