package com.petstore.api.services;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;

public class RequestSpecifications {

    private static final RequestSpecification specification = new RequestSpecBuilder().addHeader("Content-Type", "application/json").build();

    public static RequestSpecification getJsonContentType(){
        return specification;
    };


}
