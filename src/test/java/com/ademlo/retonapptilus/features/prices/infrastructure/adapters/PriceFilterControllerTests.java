package com.ademlo.retonapptilus.features.prices.infrastructure.adapters;

import org.hamcrest.CoreMatchers;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;

@SpringBootTest
@AutoConfigureMockMvc
@ActiveProfiles("test")
@DisplayName("Price Filter Controller Tests")
public class PriceFilterControllerTests {

    @Autowired
    private MockMvc mockMvc;

    final long productId = 35455L;
    final int brandId = 1;

    @Test
    @DisplayName("When call Controller with /price?productId=35455&brandId=1&date=2020-06-14 10:00:00 - Get price 35,50 and return HttpStatus OK")
    public void price_for_date20200614_10_00_00_should_retrieve_the_price_35_50_and_return_200() throws Exception {
        //Given
        final String dateToParse = "2020-06-14 10:00:00";
        final Double priceExpected = 35.50D;

        //When
        ResultActions response = mockMvc.perform(
                        get("/price?productId="+ productId + "&brandId="+ brandId +"&date="+ dateToParse)
                                .contentType(MediaType.APPLICATION_JSON)
                                .characterEncoding("UTF-8"))
                .andDo(print());

        //Then
        response.andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.productId", CoreMatchers.is((int) productId)))
                .andExpect(MockMvcResultMatchers.jsonPath("$.brandId", CoreMatchers.is(brandId)))
                .andExpect(MockMvcResultMatchers.jsonPath("$.price", CoreMatchers.is(priceExpected)));
    }

    @Test
    @DisplayName("When call Controller with /price?productId=35455&brandId=1&date=2020-06-14 16:00:00 - Get price 25,45 and return HttpStatus OK")
    public void price_for_date20200614_16_00_00_should_retrieve_the_price_25_45_and_return_200() throws Exception {
        //Given
        final String dateToParse = "2020-06-14 16:00:00";
        final Double priceExpected = 25.45D;

        //When
        ResultActions response = mockMvc.perform(
                        get("/price?productId="+ productId + "&brandId="+ brandId +"&date="+ dateToParse)
                                .contentType(MediaType.APPLICATION_JSON)
                                .characterEncoding("UTF-8"))
                .andDo(print());

        //Then
        response.andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.productId", CoreMatchers.is((int) productId)))
                .andExpect(MockMvcResultMatchers.jsonPath("$.brandId", CoreMatchers.is(brandId)))
                .andExpect(MockMvcResultMatchers.jsonPath("$.price", CoreMatchers.is(priceExpected)));
    }

    @Test
    @DisplayName("When call Controller with /price?productId=35455&brandId=1&date=2020-06-14 21:00:00 - Get price 35,50 and return HttpStatus OK")
    public void price_for_date20200614_21_00_00_should_retrieve_the_price_30_50d_and_return_200() throws Exception {
        //Given
        final String dateToParse = "2020-06-14 21:00:00";
        final Double priceExpected = 35.50D;

        //When
        ResultActions response = mockMvc.perform(
                        get("/price?productId="+ productId + "&brandId="+ brandId +"&date="+ dateToParse)
                                .contentType(MediaType.APPLICATION_JSON)
                                .characterEncoding("UTF-8"))
                .andDo(print());

        //Then
        response.andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.productId", CoreMatchers.is((int) productId)))
                .andExpect(MockMvcResultMatchers.jsonPath("$.brandId", CoreMatchers.is(brandId)))
                .andExpect(MockMvcResultMatchers.jsonPath("$.price", CoreMatchers.is(priceExpected)));
    }

    @Test
    @DisplayName("When call Controller with /price?productId=35455&brandId=1&date=2020-06-15 10:00:00 - Get price 30,50 and return HttpStatus OK")
    public void price_for_date20200615_10_00_00_should_retrieve_the_price_30_50_and_return_200() throws Exception {
        //Given
        final String dateToParse = "2020-06-15 10:00:00";
        final Double priceExpected = 30.50D;

        //When
        ResultActions response = mockMvc.perform(
                        get("/price?productId="+ productId + "&brandId="+ brandId +"&date="+ dateToParse)
                                .contentType(MediaType.APPLICATION_JSON)
                                .characterEncoding("UTF-8"))
                .andDo(print());

        //Then
        response.andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.productId", CoreMatchers.is((int) productId)))
                .andExpect(MockMvcResultMatchers.jsonPath("$.brandId", CoreMatchers.is(brandId)))
                .andExpect(MockMvcResultMatchers.jsonPath("$.price", CoreMatchers.is(priceExpected)));
    }

    @Test
    @DisplayName("When call Controller with /price?productId=35455&brandId=1&date=2020-06-16 21:00:00 - Get price 38,95 and return HttpStatus OK")
    public void price_for_date20200616_21_00_00_should_retrieve_the_price_38_95_and_return_200() throws Exception {
        //Given
        final String dateToParse = "2020-06-16 21:00:00";
        final Double priceExpected = 38.95D;

        //When
        ResultActions response = mockMvc.perform(
                        get("/price?productId="+ productId + "&brandId="+ brandId +"&date="+ dateToParse)
                                .contentType(MediaType.APPLICATION_JSON)
                                .characterEncoding("UTF-8"))
                .andDo(print());

        //Then
        response.andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.productId", CoreMatchers.is((int) productId)))
                .andExpect(MockMvcResultMatchers.jsonPath("$.brandId", CoreMatchers.is(brandId)))
                .andExpect(MockMvcResultMatchers.jsonPath("$.price", CoreMatchers.is(priceExpected)));
    }
}
