package com.returnpredictor.api.dto.request;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class BehaviorDTO {

  @NotNull private Integer viewCount;

  @NotNull private Integer addedToCartCount;

  @NotNull private Boolean supportContacted;

  private Integer sessionDuration;

  private Integer sameCategoryRecentOrders;
}
