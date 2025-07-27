package com.returnpredictor.api.dto.request;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class OrderDTO {

  @NotBlank private String paymentMode;

  @NotBlank private String orderDate; // ISO format

  @NotBlank private String deliveryRegion;
}
