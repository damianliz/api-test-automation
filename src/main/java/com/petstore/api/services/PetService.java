package com.petstore.api.services;

import com.petstore.api.config.CommonSpec;
import com.petstore.api.models.pet.PetRequestBody;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class PetService {

    private final static String PET_BASE_PATH = "/pet";

    public Response findPetById(int petId) {
        return given().spec(CommonSpec.getReqSpec()).pathParam("petId", petId).get(PET_BASE_PATH + "/{petId}");
    }

    public Response addNewPet(PetRequestBody petBody) {
        return given().spec(CommonSpec.getReqSpec()).body(petBody).post(PET_BASE_PATH);
    }

    public Response updateExistingPet(PetRequestBody petBody) {
        return given().spec(CommonSpec.getReqSpec()).body(petBody).put(PET_BASE_PATH);
    }

    public Response deletePet(int petId) {
        return given().spec(CommonSpec.getReqSpec()).pathParam("petId", petId).get(PET_BASE_PATH + "/{petId}");
    }
}
