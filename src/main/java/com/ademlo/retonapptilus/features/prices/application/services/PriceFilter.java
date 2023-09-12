package com.ademlo.retonapptilus.features.prices.application.services;

import com.ademlo.retonapptilus.features.prices.domain.models.Price;
import com.ademlo.retonapptilus.features.prices.application.usecases.PriceFilterUseCase;
import com.ademlo.retonapptilus.features.prices.domain.repository.PriceFilterRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.Instant;

@Service
@AllArgsConstructor
public class PriceFilter implements PriceFilterUseCase {

    private final PriceFilterRepository priceFilterRepository;
    public Price filterProductByIdDateAndBrand(Long productId, Integer brandId, Instant date){
        return priceFilterRepository.filterProductByIdDateAndBrand(productId, brandId, date);
    }
}
