package com.watchmile.fcm.tddservice.product.repository;

import com.watchmile.fcm.tddservice.product.entity.Product;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

@Repository
public class ProductMemoryRepository {
    private long sequence = 0L;
    private final Map<Long, Product> persistence = new HashMap<>();

    public void save(Product product) {
        product.assignId(++sequence);
        persistence.put(product.getId(), product);
    }
}
