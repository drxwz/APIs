package com.endava.petclinic.client;

import com.endava.petclinic.model.PetType;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class PetTypeClient extends BaseClient {
    public Response getPetType() {
        return getBasicRestConfig()
                .contentType(ContentType.JSON)
                .get("/api/pettypes");
    }

    public Response createPetType(PetType petType) {
        return getBasicRestConfig()
                .contentType(ContentType.JSON)
                .body(petType)
                .post("/api/pettypes");
    }

    public Response getPetTypeById(Long petTypeId) {
        return getBasicRestConfig()
                .pathParam("petTypeId", petTypeId)
                .get("/api/pettypes/{petTypeId}");
    }

    public Response deletePetType(Long petTypeId) {
        return getBasicRestConfig()
                .pathParam("petTypeId", petTypeId)
                .delete("api/pettypes/{petTypeId}");
    }
}
