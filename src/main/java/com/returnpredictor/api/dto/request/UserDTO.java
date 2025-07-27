package com.returnpredictor.api.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class UserDTO {

  @NotBlank private String userId;

  @NotNull private Boolean isNewUser;

  @NotNull private Double returnRate;

  @NotNull private Double pastCancellationRate;

  private Integer pastRTOCount;

  private Integer daysSinceLastReturn;
}
