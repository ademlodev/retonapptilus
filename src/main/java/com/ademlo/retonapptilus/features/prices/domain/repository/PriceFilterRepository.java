package com.ademlo.retonapptilus.features.prices.domain.repository;

import com.ademlo.retonapptilus.features.prices.domain.models.Price;
import java.time.Instant;

public interface PriceFilterRepository {

    Price filterProductByIdDateAndBrand(Long productId, Integer brandId, Instant date);
}
