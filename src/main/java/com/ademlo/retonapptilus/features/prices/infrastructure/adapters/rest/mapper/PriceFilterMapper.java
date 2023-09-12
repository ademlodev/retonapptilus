package com.ademlo.retonapptilus.features.prices.infrastructure.adapters.rest.mapper;

import com.ademlo.retonapptilus.features.prices.domain.models.Price;
import com.ademlo.retonapptilus.features.prices.domain.models.PriceFilterResponseDTO;

public interface PriceFilterMapper {

    PriceFilterResponseDTO fromDomainToDTO(Price price);

}
