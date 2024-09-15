package com.petstore.api.services;

import com.petstore.api.models.pet.PetRequestBody;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class PetService {

    private final static String BASE_PATH = "/pet";

    public Response findPetById(int petId) {
        return given().spec(RequestSpecifications.getJsonContentType()).pathParam("/{petId}", petId).get(BASE_PATH);
    }

    public Response addNewPet(PetRequestBody petBody) {
        return given().spec(RequestSpecifications.getJsonContentType()).body(petBody).post(BASE_PATH);
    }
}
