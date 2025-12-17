package com.watchmile.fcm.tddservice.product;

import com.watchmile.fcm.tddservice.ApiTest;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.ExtractableResponse;
import io.restassured.response.Response;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;

import static com.watchmile.fcm.tddservice.product.ProductSteps.상품등록요청;
import static com.watchmile.fcm.tddservice.product.ProductSteps.상품등록요청생성;
import static org.assertj.core.api.Assertions.assertThat;

public class ProductApiTest extends ApiTest {


    @Test
    void 상품등록() {
        var request = 상품등록요청생성();
        var response = 상품등록요청(request);
        assertThat(response.statusCode()).isEqualTo(HttpStatus.CREATED.value());
    }

    @Test
    void 상품조회() {

        var request = 상품등록요청생성();
        var res = 상품등록요청(request);

        ExtractableResponse<Response> response = RestAssured.given().log().all()
                .contentType(ContentType.JSON)
                .param("productId", 1L)
                .when()
                .get("products")
                .then()
                .log().all()
                .extract();

        assertThat(response.statusCode()).isEqualTo(HttpStatus.OK.value());
        assertThat(response.body().jsonPath().getLong("productId")).isEqualTo(1L);
    }
}
