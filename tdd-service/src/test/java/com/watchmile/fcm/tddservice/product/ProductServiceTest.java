package com.watchmile.fcm.tddservice.product;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.util.Assert;

import java.security.Provider;
import java.util.HashMap;
import java.util.Map;

public class ProductServiceTest {

    private ProductService productService;
    private ProductPort productPort;
    private ProductRepository productRepository;

    @BeforeEach
    void setUp() {
        productRepository = new ProductRepository();
        productPort = new ProductAdapter(productRepository);
        productService = new ProductService(productPort);
    }

    @Test
    void 상품등록() {
        final String name = "상품명";
        final int price = 1000;
        DiscountPolicy discountPolicy = DiscountPolicy.NONE;
        final AddProductRequest request = new AddProductRequest(name, price, discountPolicy);
        productService.addProduct(request);

    }

    private enum DiscountPolicy {
        NONE
    }


    private record AddProductRequest(String name, long price, DiscountPolicy discountPolicy) {
        private AddProductRequest
        {
            Assert.hasText(name, "상품명은 필수입니다.");
            Assert.isTrue(price > 0, "상품가격은 0보다 커야합니다.");
            Assert.notNull(discountPolicy, "할인정책은 필수입니다.");
        }

    }

    private record ProductService(ProductPort productPort) {

        void addProduct(final AddProductRequest request) {

                Product product = new Product(request.name(), request.price, request.discountPolicy);

                productPort.save(product);
            }


    }

    interface ProductPort {
        public void save(Product product);
    }


    private static class Product {

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

    private class ProductAdapter implements ProductPort {

        private final ProductRepository productRepository;

        private ProductAdapter(ProductRepository productRepository) {
            this.productRepository = productRepository;
        }

        @Override
        public void save(Product product) {
            productRepository.save(product);
        }
    }

    private class ProductRepository {
        private long sequence = 0L;
        private final Map<Long, Product> persistence = new HashMap<>();


        public void save(Product product) {
            product.assignId(++sequence);
            persistence.put(product.getId(), product);
        }
    }
}
