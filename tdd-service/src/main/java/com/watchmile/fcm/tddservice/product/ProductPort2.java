package com.watchmile.fcm.tddservice.product;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@Primary
class ProductAdapter2 implements ProductPort {

    private final ProductRepository productRepository;

    ProductAdapter2(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public void save(Product product) {
        productRepository.save(product);
    }
}
