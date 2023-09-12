package com.ademlo.retonapptilus.features.prices.infrastructure.adapters.db;

import com.ademlo.retonapptilus.features.prices.domain.models.Price;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import java.time.Instant;

public interface PriceFilterJPARepository extends CrudRepository<Price, Long> {

    @Query(nativeQuery = true, value =
            " SELECT pr.product_id, pr.brand_id, pr.price_list, pr.price, pr.start_date, pr.end_date, pr.currency, pr.priority\n" +
                    "FROM PRICE pr \n" +
                    "WHERE pr.product_id=?1 and\n" +
                    "      pr.brand_id = ?2 and\n" +
                    "      pr.start_date <= ?3 AND\n" +
                    "      pr.end_date >= ?3 AND\n" +
                    "      pr.PRIORITY = (" +
                    "            SELECT MAX(p.PRIORITY) " +
                    "            FROM PRICE p " +
                    "            WHERE p.product_id=?1 and\n" +
                    "             p.brand_id = ?2 and\n" +
                    "             p.start_date <= ?3 AND\n" +
                    "             p.end_date >= ?3 ) ")
    Price findByProductIdBrandIdAndDate(Long productId, Integer brandId, Instant date);
}
