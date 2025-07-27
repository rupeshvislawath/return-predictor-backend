package com.returnpredictor.api.dto.request;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class PredictionRequest {

  @NotNull @Valid private UserDTO user;

  @NotNull @Valid private ProductDTO product;

  @Valid private SellerDTO seller;

  @NotNull @Valid private OrderDTO order;

  @NotNull @Valid private BehaviorDTO behavior;
}
