package com.returnpredictor.api.dto.response;

import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ReturnPredictionResponse {

  /** Return likelihood score between 0.0 and 1.0 */
  private Double returnProbability;

  /** Risk level classified as LOW, MEDIUM, or HIGH */
  private String riskLevel;

  /** Recommended action for platform or UI */
  private String recommendation;

  /** List of reasons/rules triggered for this prediction */
  private List<String> reasonCodes;
}
