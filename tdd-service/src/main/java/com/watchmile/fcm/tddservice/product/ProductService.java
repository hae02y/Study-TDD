package com.watchmile.fcm.tddservice.product;

record ProductService(ProductPort productPort) {

    void addProduct(final AddProductRequest request) {

        Product product = new Product(request.name(), request.price(), request.discountPolicy());

        productPort.save(product);
    }


}
