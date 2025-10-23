package com.example.drone.domain;

import java.util.Objects;

public class Drone {
  private final DroneId id;
  private final DroneModel model;
  private final Speed speed;

  public Drone(DroneId id, DroneModel model, Speed speed) {
    this.id = this.validateDroneId(id);
    this.model = this.validateDroneModel(model);
    this.speed = this.validateSpeed(speed);
  }

  public DroneId id() {
    return this.id;
  }

  public DroneModel model() {
    return this.model;
  }

  public Speed speed() {
    return this.speed;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof Drone that)) {
      return false;
    }
    return Objects.equals(this.id, that.id);
  }

  @Override
  public int hashCode() {
    return Objects.hash(this.id);
  }

  private DroneId validateDroneId(DroneId id) {
    return Objects.requireNonNull(id, "DroneId must not be null");
  }

  private DroneModel validateDroneModel(DroneModel model) {
    return Objects.requireNonNull(model, "DroneModel must not be null");
  }

  private Speed validateSpeed(Speed speed) {
    return Objects.requireNonNull(speed, "Speed must not be null");
  }
}
