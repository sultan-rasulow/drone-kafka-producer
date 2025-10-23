package com.example.drone.infrastructure.web.dto;

import jakarta.validation.constraints.DecimalMax;
import jakarta.validation.constraints.DecimalMin;
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
public class CoordinatesRequest implements Serializable {

  @NotNull(message = "Latitude must not be null")
  @DecimalMin(value = "-90.0", message = "Latitude must be >= -90")
  @DecimalMax(value = "90.0", message = "Latitude must be <= 90")
  private Double latitude;

  @NotNull(message = "Longitude must not be null")
  @DecimalMin(value = "-180.0", message = "Longitude must be >= -180")
  @DecimalMax(value = "180.0", message = "Longitude must be <= 180")
  private Double longitude;

  @NotNull(message = "Altitude must not be null")
  @PositiveOrZero(message = "Altitude must be non-negative")
  private Double altitude;

  @NotBlank(message = "DetectedBy must be provided")
  private String detectedBy;
}
