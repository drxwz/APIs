package com.endava.petclinic.client;

import com.endava.petclinic.model.Pet;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class PetClient extends BaseClient {

    public Response createPet(Pet pet) {
        return getBasicRestConfig()
                .contentType(ContentType.JSON)
                .body(pet)
                .post("/api/pets");
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
                .put("api/pets/{petId}");
    }
}

