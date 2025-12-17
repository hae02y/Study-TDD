package com.watchmile.fcm.tddservice.product;

import com.watchmile.fcm.tddservice.product.entity.Product;
import com.watchmile.fcm.tddservice.product.repository.ProductMemoryRepository;
import org.springframework.stereotype.Component;

@Component
class ProductAdapter2 implements ProductPort {

    private final ProductMemoryRepository productMemoryRepository;

    ProductAdapter2(ProductMemoryRepository productMemoryRepository) {
        this.productMemoryRepository = productMemoryRepository;
    }

    @Override
    public void save(Product product) {
        productMemoryRepository.save(product);
    }

    @Override
    public Product get(long id) {
        return null;
    }
}
