package com.watchmile.fcm.tddservice.product;

import org.springframework.util.Assert;

record GetProductResponse(
        long productId,
        String name,
        long price,
        DiscountPolicy discountPolicy
) {
    public GetProductResponse {
        Assert.hasText(name, "name must not be empty");
        Assert.notNull(productId, "productId must not be null");
        Assert.notNull(price, "price must not be null");
        Assert.notNull(discountPolicy, "discountPolicy must not be null");
    }
}
