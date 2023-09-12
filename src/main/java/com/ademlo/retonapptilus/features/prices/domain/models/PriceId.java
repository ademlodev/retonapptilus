package com.ademlo.retonapptilus.features.prices.domain.models;

import lombok.NoArgsConstructor;
import java.io.Serializable;

@NoArgsConstructor
public class PriceId implements Serializable {
    private Long productId;
    private Integer brandId;
    private Integer priceList;
}
