package com.ademlo.retonapptilus.features.prices.domain.models;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import java.time.Instant;

@AllArgsConstructor
public class PriceFilterResponseDTO {
        @JsonFormat
        private Long productId;
        @JsonFormat
        private Integer brandId;
        @JsonFormat
        private Integer priceList;
        @JsonFormat(shape=JsonFormat.Shape.STRING, pattern="yyyy-MM-dd'T'HH:mm:ss",timezone = "UTC")
        private Instant starDate;
        @JsonFormat(shape=JsonFormat.Shape.STRING, pattern="yyyy-MM-dd'T'HH:mm:ss",timezone = "UTC")
        private Instant endDate;
        @JsonFormat
        private Double price;
}
