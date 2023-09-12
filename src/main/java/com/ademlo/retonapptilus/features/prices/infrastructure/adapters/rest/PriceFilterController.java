package com.ademlo.retonapptilus.features.prices.infrastructure.adapters.rest;

import com.ademlo.retonapptilus.features.prices.application.usecases.PriceFilterUseCase;
import com.ademlo.retonapptilus.features.prices.domain.models.PriceFilterResponseDTO;
import com.ademlo.retonapptilus.features.prices.infrastructure.adapters.rest.mapper.PriceFilterMapper;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.AllArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.time.Instant;
import java.util.Date;

@RestController
@RequestMapping("/price")
@AllArgsConstructor
public class PriceFilterController {

    private final PriceFilterUseCase priceFilterUseCase;
    private final PriceFilterMapper priceFilterMapper;

    @Operation(summary = "Get a price by its productId, brandId and date")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Found the price",
                    content = { @Content(mediaType = "application/json",
                            schema = @Schema(implementation = PriceFilterResponseDTO.class)) }),
            @ApiResponse(responseCode = "404", description = "Price not found",
                    content = @Content) })
    @GetMapping("")
    public ResponseEntity<PriceFilterResponseDTO> filterProductByIdDateAndBrand(
            @Valid @RequestParam Long productId,
            @Valid @RequestParam Integer brandId,
            @Valid @RequestParam @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss") Date date
            ){
        Instant dateInstant = date.toInstant();
        PriceFilterResponseDTO response = priceFilterMapper.fromDomainToDTO(priceFilterUseCase
                .filterProductByIdDateAndBrand(productId, brandId, dateInstant));
        //TODO response 404 price not found if (response.)
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
