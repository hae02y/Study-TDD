package com.watchmile.fcm.tddservice.product;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Primary
@Component
class ProductAdapter implements ProductPort {

    private final ProductRepository productRepository;

    ProductAdapter(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public void save(Product product) {
        productRepository.save(product);
    }
}
