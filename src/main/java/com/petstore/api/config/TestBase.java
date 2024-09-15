package com.petstore.api.config;

import com.petstore.api.services.PetService;
import io.restassured.RestAssured;
import org.testng.annotations.BeforeSuite;


public class TestBase {

    protected PetService petService;

    @BeforeSuite
    public void setup() {
        RestAssured.baseURI = "http://localhost:8080/";
        petService = new PetService();
    }
}
