package com.returnpredictor.api.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class ProductDTO {

  @NotBlank private String productId;

  @NotBlank private String category;

  @NotBlank private String brand;

  @NotNull private Double price;

  @NotNull private Double rating;
}
