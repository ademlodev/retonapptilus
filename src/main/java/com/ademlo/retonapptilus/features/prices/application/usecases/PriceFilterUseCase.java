package com.ademlo.retonapptilus.features.prices.application.usecases;

import com.ademlo.retonapptilus.features.prices.domain.models.Price;
import java.time.Instant;

public interface PriceFilterUseCase {
    Price filterProductByIdDateAndBrand(Long productId, Integer brandId, Instant date);
}
