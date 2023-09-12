package com.ademlo.retonapptilus.features.prices.domain.models;

import lombok.Getter;
import lombok.NoArgsConstructor;
import javax.persistence.*;
import java.io.Serializable;
import java.time.Instant;

@Entity
@NoArgsConstructor
@Getter
@Table(name = "price")
@IdClass(PriceId.class)
public class Price implements Serializable {

    @Id
    @Column(name ="product_id", nullable = false)
    private Long productId;

    @Id
    @Column(name ="brand_id", nullable = false)
    private Integer brandId;

    @Id
    @Column(name="price_list", nullable = false)
    private Integer priceList;

    @Column(name="start_date", nullable = false)
    private Instant startDate;

    @Column(name = "end_date", nullable = false)
    private Instant endDate;

    @Column(nullable = false)
    private Integer priority;

    @Column(nullable = false)
    private Double price;

    @Column(nullable = false)
    private String currency;
}
