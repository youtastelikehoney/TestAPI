package ru.netology.rest;

import io.restassured.http.ContentType;
import org.junit.jupiter.api.Test;


import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;



class MobileBankApiTestV7 {
    @Test
    void shouldReturnDemoAccounts () {
        given ()
                .baseUri("http://localhost:9999/api/v1")
                .when()
                .get("/demo/accounts")
                .then()
                .statusCode(200)
                .contentType(ContentType.JSON)
                .body("[0].id",equalTo(1))
                .body("[1].id", equalTo(2))
                .body("[2].id", equalTo(2));
    }
}
