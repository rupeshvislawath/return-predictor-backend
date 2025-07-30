package com.returnpredictor.service.impl;

import static com.returnpredictor.utils.AppConstants.*;

import com.returnpredictor.api.dto.request.ReturnPredictionRequest;
import com.returnpredictor.api.dto.response.ReturnPredictionResponse;
import com.returnpredictor.enums.Recommendation;
import com.returnpredictor.service.ReturnPredictionService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class ReturnPredictionServiceImpl implements ReturnPredictionService {

  @Override
  public ReturnPredictionResponse predict(ReturnPredictionRequest request) {
    log.info("Received prediction request: {}", request);

    // Mock logic for now: You can plug ML/heuristics later
    double probability = mockCalculateReturnProbability(request);
    String recommendation = mockRecommendation(probability);
    return ReturnPredictionResponse.builder()
        .returnProbability(probability)
        .riskLevel(
            probability > HIGH_RISK_RATE ? HIGH : probability > MEDIUM_RISK_RATE ? MEDIUM : LOW)
        .recommendation(recommendation)
        .build();
  }

  private double mockCalculateReturnProbability(ReturnPredictionRequest request) {
    // For now, base it on some dummy logic
    double base = 0.2;

    if (COD.equalsIgnoreCase(request.getOrder().getPaymentMode())) {
      base += 0.3;
    }
    if (request.getBehavior().getPastCancellationRate() > 0.5) {
      base += 0.3;
    }

    return Math.min(base, 1.0); // Ensure max is 1.0
  }

  private String mockRecommendation(double returnProbability) {
    if (returnProbability > HIGH_RISK_RATE) {
      return Recommendation.BLOCK_RETURN_PRIVILEGES.getLabel();
    } else if (returnProbability > MEDIUM_RISK_RATE) {
      return Recommendation.FLAG_FOR_MANUAL_REVIEW.getLabel();
    }
    return Recommendation.ALLOW.getLabel();
  }
}
