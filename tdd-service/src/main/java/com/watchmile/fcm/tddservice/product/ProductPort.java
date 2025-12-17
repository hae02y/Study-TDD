package com.watchmile.fcm.tddservice.product;

import com.watchmile.fcm.tddservice.product.entity.Product;
import org.springframework.stereotype.Component;

@Component
interface ProductPort {
    public void save(Product product);
}
