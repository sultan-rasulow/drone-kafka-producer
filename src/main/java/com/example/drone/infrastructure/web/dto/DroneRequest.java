package com.example.drone.infrastructure.web.dto;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;
import java.io.Serializable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class DroneRequest implements Serializable {

  @NotBlank(message = "Drone model must not be blank")
  private String model;

  @NotNull(message = "Drone speed must not be null")
  @PositiveOrZero(message = "Drone speed must be non-negative")
  private Double speed;

  @Valid
  @NotNull(message = "Coordinates must be provided")
  private CoordinatesRequest coordinates;
}
