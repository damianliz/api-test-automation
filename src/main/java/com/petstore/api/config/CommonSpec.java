package com.petstore.api.config;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;

public class CommonSpec {

    private static final RequestSpecification specification = new RequestSpecBuilder()
            .setBaseUri("http://localhost:8080")
            .setBasePath("/api/v3")
            .addHeader("Content-Type", "application/json")
            .build();

    public static RequestSpecification getReqSpec() {
        return specification;
    }


}
