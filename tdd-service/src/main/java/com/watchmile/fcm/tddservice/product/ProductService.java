package com.watchmile.fcm.tddservice.product;

import com.watchmile.fcm.tddservice.product.entity.Product;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/products")
record ProductService(ProductPort productPort) {

    @PostMapping("add")
    public ResponseEntity<?> addProduct(@RequestBody AddProductRequest request) {
        Product product = new Product(request.name(), request.price(), request.discountPolicy());
        productPort.save(product);

        return ResponseEntity.status(HttpStatus.CREATED).build();
    }


    @GetMapping
    public GetProductResponse getProduct(@RequestParam long productId) {
        Product product = productPort.get(productId);
        if(product == null) return null;
        return new GetProductResponse(product.getId(), product.getName(), product.getPrice(), product.getDiscountPolicy());
    }
}
