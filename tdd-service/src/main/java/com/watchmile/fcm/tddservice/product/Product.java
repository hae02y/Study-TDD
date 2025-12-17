package com.watchmile.fcm.tddservice.product;

import org.springframework.util.Assert;

class Product {

    private final String name;
    private final long price;
    private final DiscountPolicy discountPolicy;
    private long id;

    public Product(String name, long price, DiscountPolicy discountPolicy) {
        Assert.hasText(name, "상품명은 필수입니다.");
        Assert.isTrue(price > 0, "상품가격은 0보다 커야합니다.");
        Assert.notNull(discountPolicy, "할인정책은 필수입니다.");

        this.name = name;
        this.price = price;
        this.discountPolicy = discountPolicy;
    }

    public String getName() {
        return name;
    }

    public long getPrice() {
        return price;
    }

    public DiscountPolicy getDiscountPolicy() {
        return discountPolicy;
    }

    public void assignId(long id) {
        this.id = id;
    }

    public long getId() {
        return id;
    }
}
