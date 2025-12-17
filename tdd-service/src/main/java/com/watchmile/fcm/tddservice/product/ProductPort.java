package com.watchmile.fcm.tddservice.product;

import org.springframework.stereotype.Component;

@Component
interface ProductPort {
    public void save(Product product);
}
