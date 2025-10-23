package com.example.drone.domain;

import java.util.Objects;
import java.util.UUID;

public final class DroneId {

  private final UUID value;

  private DroneId(UUID value) {
    this.value = Objects.requireNonNull(value, "DroneId value must not be null");
  }

  public static DroneId of(UUID value) {
    return new DroneId(value);
  }

  public static DroneId generate() {
    return new DroneId(UUID.randomUUID());
  }

  public static DroneId parse(String uuid) {
    return new DroneId(UUID.fromString(uuid));
  }

  public UUID value() {
    return this.value;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof DroneId that)) {
      return false;
    }
    return Objects.equals(this.value, that.value);
  }

  @Override
  public int hashCode() {
    return Objects.hashCode(this.value);
  }

  @Override
  public String toString() {
    return "DroneId[" + this.value + "]";
  }
}
