package com.watchmile.fcm.tddservice.product;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Objects;

import static org.assertj.core.api.Assertions.*;

@SpringBootTest
public class ProductServiceTest {

    @Autowired
    private ProductService productService;

    @Test
    void 상품조회() {
        //상품등록
        productService.addProduct(ProductSteps.상품등록요청생성());
        final long productId = 1L;

        //상품을 조회
        final GetProductResponse response = Objects.requireNonNull(productService.getProduct(productId)).getBody();

        //상품의 응답을 검증
        assertThat(response).isNotNull();
        assertThat(response.name()).isEqualTo("상품명");
    }

}
