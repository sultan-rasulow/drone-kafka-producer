package com.example.drone.domain;

import java.util.Objects;

public final class DroneModel {

  private final String name;

  public DroneModel(String name) {
    this.name = this.validateName(name);
  }

  public String name() {
    return this.name;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof DroneModel that)) {
      return false;
    }
    return Objects.equals(this.name, that.name);
  }

  @Override
  public int hashCode() {
    return Objects.hashCode(this.name);
  }

  @Override
  public String toString() {
    return String.format("DroneModel[%s]", this.name);
  }

  private String validateName(String name) {
    if (name == null || name.isBlank()) {
      throw new IllegalArgumentException("Drone model name must not be blank");
    }
    return name.trim();
  }
}
