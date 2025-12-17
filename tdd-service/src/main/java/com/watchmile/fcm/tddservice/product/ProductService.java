package com.watchmile.fcm.tddservice.product;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/products")
record ProductService(ProductPort productPort) {

    @PostMapping("add")
    public ResponseEntity<?> addProduct(@RequestBody AddProductRequest request) {
        Product product = new Product(request.name(), request.price(), request.discountPolicy());
        productPort.save(product);

        return ResponseEntity.status(HttpStatus.CREATED).build();
    }


}
