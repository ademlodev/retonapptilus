package com.ademlo.retonapptilus.features.prices.application.services;

import com.ademlo.retonapptilus.features.prices.domain.models.Price;
import com.ademlo.retonapptilus.features.prices.domain.repository.PriceFilterRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import java.util.Date;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verifyNoMoreInteractions;

@DisplayName("Price Filter Port Test")
public class PriceFilterTests {

    @InjectMocks
    PriceFilter sut;

    @Mock
    private PriceFilterRepository priceFilterRepositoryMock;

    @BeforeEach
    void setSut(){
        priceFilterRepositoryMock = mock(PriceFilterRepository.class);
        sut = new PriceFilter(priceFilterRepositoryMock);
    }

    @Test
    @DisplayName("When call service - return Price of date selected")
    void priceFilter_should_return_price_when_possible(){
        //Given
        final Long productId = 1L;
        final Integer brandId = 1;
        final Date date = new Date();
        final var priceMock = mock(Price.class);

        Mockito.when(priceFilterRepositoryMock.filterProductByIdDateAndBrand(productId,brandId,date.toInstant())).thenReturn(priceMock);

        //When
        final Price pricesFounded = sut.filterProductByIdDateAndBrand(productId,brandId,date.toInstant());

        //Then
        assertNotNull(priceMock);
        assertNotNull(pricesFounded);
        assertEquals(priceMock, pricesFounded);

        //Mutation Test
        Mockito.verify(priceFilterRepositoryMock, Mockito.times(1)).filterProductByIdDateAndBrand(productId,brandId,date.toInstant());
        verifyNoMoreInteractions(priceFilterRepositoryMock);
    }
}
