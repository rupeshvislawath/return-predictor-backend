package com.returnpredictor.api.dto.request;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class SellerDTO {

  @NotBlank private String sellerId;

  private Double rating;

  private Double returnRate;

  private Boolean isVerified;
}
