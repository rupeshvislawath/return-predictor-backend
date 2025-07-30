package com.returnpredictor.api.controller;

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
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
@Tag(
    name = "Return Prediction",
    description = "Predict the probability and risk of a product return")
public class ReturnPredictionController {

  private final ReturnPredictionService predictionService;

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
      @Valid @RequestBody ReturnPredictionRequest request) {

    ReturnPredictionResponse response = predictionService.predict(request);
    return ResponseEntity.ok(response);
  }
}
