package com.returnpredictor.api.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.returnpredictor.api.dto.request.ReturnPredictionRequest;
import com.returnpredictor.api.dto.response.ReturnPredictionResponse;
import com.returnpredictor.service.ReturnPredictionService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
@Slf4j
@Tag(
    name = "Return Prediction",
    description = "Predict the probability and risk of a product return")
public class ReturnPredictionController {

  private final ReturnPredictionService predictionService;
  private final ObjectMapper objectMapper;

  @Operation(
      summary = "Predict Return Likelihood",
      description = "Takes user, order, product, and behavioral data to predict return probability")
  @ApiResponses(
      value = {
        @ApiResponse(
            responseCode = "200",
            description = "Successful prediction",
            content =
                @Content(
                    mediaType = "application/json",
                    schema = @Schema(implementation = ReturnPredictionResponse.class))),
        @ApiResponse(responseCode = "400", description = "Invalid input", content = @Content),
        @ApiResponse(
            responseCode = "500",
            description = "Internal server error",
            content = @Content)
      })
  @PostMapping("/predict")
  public ResponseEntity<ReturnPredictionResponse> predictReturn(
      @Valid @RequestBody ReturnPredictionRequest request) throws JsonProcessingException {
    log.info("Prediction Request: {}", objectMapper.writeValueAsString(request));
    ReturnPredictionResponse response = predictionService.predict(request);
    log.info("Prediction Response: {}", objectMapper.writeValueAsString(response));
    return ResponseEntity.ok(response);
  }
}
