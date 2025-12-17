package com.watchmile.fcm.tddservice.product;

import com.watchmile.fcm.tddservice.product.entity.Product;
import com.watchmile.fcm.tddservice.product.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Primary
@Component
@RequiredArgsConstructor
class ProductAdapter implements ProductPort {

    private final ProductRepository productRepository;

    @Override
    public void save(Product product) {
        productRepository.save(product);
    }
}
