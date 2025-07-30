package com.returnpredictor.api.dto.request;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@JsonIgnoreProperties(ignoreUnknown = true)
@Data
public class ReturnPredictionRequest {

  @NotNull @Valid private UserDTO user;

  @NotNull @Valid private ProductDTO product;

  @Valid private SellerDTO seller;

  @NotNull @Valid private OrderDTO order;

  @NotNull @Valid private BehaviorDTO behavior;
}
