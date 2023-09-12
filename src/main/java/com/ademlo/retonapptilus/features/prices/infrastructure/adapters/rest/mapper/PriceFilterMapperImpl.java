package com.ademlo.retonapptilus.features.prices.infrastructure.adapters.rest.mapper;

import com.ademlo.retonapptilus.features.prices.domain.models.Price;
import com.ademlo.retonapptilus.features.prices.domain.models.PriceFilterResponseDTO;
import org.springframework.stereotype.Component;

@Component
public class PriceFilterMapperImpl implements PriceFilterMapper{

    @Override
    public PriceFilterResponseDTO fromDomainToDTO(Price price) {
        return new PriceFilterResponseDTO(
                price.getProductId(),
                price.getBrandId(),
                price.getPriceList(),
                price.getStartDate(),
                price.getEndDate(),
                price.getPrice());
    }
}
