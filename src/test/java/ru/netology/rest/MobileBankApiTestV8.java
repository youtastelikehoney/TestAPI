package ru.netology.rest;

import io.restassured.http.ContentType;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;
import static org.hamcrest.Matchers.equalTo;

class MobileBankApiTestV8 {
    @Test
    void shouldReturnDemoAccounts () {
        given()
                .baseUri("http://localhost:9999/api/v1")
                .when()
                .get("/demo/accounts")
                .then()
                .statusCode(200)
                .contentType(ContentType.JSON)
                .body("[0].currency", equalTo("RUB"))
                .body("[1].currency", equalTo("USD"))
                .body("[2].currency", equalTo("RUb"))
                .body(matchesJsonSchemaInClasspath("accounts.schema.json"));

    }
}
