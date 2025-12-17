package com.watchmile.fcm.tddservice.product;

import com.watchmile.fcm.tddservice.product.entity.Product;
import com.watchmile.fcm.tddservice.product.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Primary
@Component
@RequiredArgsConstructor
class ProductAdapter implements ProductPort {

    private final ProductRepository productRepository;

    @Override
    public void save(Product product) {
        productRepository.save(product);
    }

    @Override
    public Product get(long id) {
        return productRepository.findById(id).orElse(null);
    }
}
