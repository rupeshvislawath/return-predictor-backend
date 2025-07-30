package com.returnpredictor.service;

import com.returnpredictor.api.dto.request.ReturnPredictionRequest;
import com.returnpredictor.api.dto.response.ReturnPredictionResponse;

public interface ReturnPredictionService {
  ReturnPredictionResponse predict(ReturnPredictionRequest request);
}
