package com.watchmile.fcm.tddservice.product;

import org.springframework.stereotype.Component;

@Component
record ProductService(ProductPort productPort) {

    public void addProduct(final AddProductRequest request) {

        Product product = new Product(request.name(), request.price(), request.discountPolicy());
        productPort.save(product);
    }


}
