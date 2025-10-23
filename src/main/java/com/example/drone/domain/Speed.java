package com.example.drone.domain;

import java.util.Objects;

public final class Speed {

  private final double metersPerSecond;

  private Speed(Double metersPerSecond) {
    this.metersPerSecond = this.validateSpeed(metersPerSecond);
  }

  public static Speed ofMetersPerSecond(double mps) {
    return new Speed(mps);
  }

  public static Speed ofKilometersPerHour(double kmh) {
    double mps = kmh / 3.6;
    return new Speed(mps);
  }

  public double metersPerSecond() {
    return this.metersPerSecond;
  }

  public double kilometersPerHour() {
    return metersPerSecond * 3.6;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof Speed that)) {
      return false;
    }
    return Objects.equals(this.metersPerSecond, that.metersPerSecond);
  }

  @Override
  public int hashCode() {
    return Objects.hashCode(this.metersPerSecond);
  }

  @Override
  public String toString() {
    return String.format("Speed[%s m/s]", this.metersPerSecond);
  }

  private double validateSpeed(double mps) {
    if (Double.isNaN(mps) || Double.isInfinite(mps)) {
      throw new IllegalArgumentException("Speed must be a valid number");
    }
    if (mps < 0) {
      throw new IllegalArgumentException("Speed must be non-negative");
    }
    return mps;
  }
}
