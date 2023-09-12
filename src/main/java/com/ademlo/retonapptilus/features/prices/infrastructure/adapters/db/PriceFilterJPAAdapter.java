package com.ademlo.retonapptilus.features.prices.infrastructure.adapters.db;

import com.ademlo.retonapptilus.features.prices.domain.models.Price;
import com.ademlo.retonapptilus.features.prices.domain.repository.PriceFilterRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import java.time.Instant;

@Component
@AllArgsConstructor
public class PriceFilterJPAAdapter implements PriceFilterRepository {

    private final PriceFilterJPARepository priceFilterJPARepository;

    @Override
    public Price filterProductByIdDateAndBrand(Long productId, Integer brandId, Instant date) {
        return priceFilterJPARepository.findByProductIdBrandIdAndDate(productId, brandId, date);
    }

}
