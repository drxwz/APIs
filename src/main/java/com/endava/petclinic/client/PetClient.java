package com.endava.petclinic.client;

import com.endava.petclinic.model.Pet;
import com.github.javafaker.Faker;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class PetClient extends BaseClient {

    private Faker faker = new Faker();

    public Response createPet(Pet pet) {

        return getBasicRestConfig()
                .contentType(ContentType.JSON)
                .body(pet)
                .post("/api/pets");
    }

    public String getNumberWithDigits(int min, int max) {
        return faker.number().digits(faker.number().numberBetween(min, max));
    }

    public Response getPetById(Long petId) {

        return getBasicRestConfig()
                .pathParam("petId", petId)
                .get("/api/pets/{petId}");
    }

    public Response getPetList() {
        return getBasicRestConfig()
                .get("api/pets");
    }

    public Response deletePet(Long petId) {
        return getBasicRestConfig()
                .pathParam("petId", petId)
                .delete("api/pets/{petId}");
    }

    public Response updatePetById(Long petId) {
        return getBasicRestConfig()
                .pathParam("petId", petId)
                .body(petId)
                .contentType(ContentType.JSON)
                .put("api/pets/{petId");
    }
}

