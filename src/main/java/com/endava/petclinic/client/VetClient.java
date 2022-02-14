package com.endava.petclinic.client;

import com.endava.petclinic.model.Vet;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class VetClient extends BaseClient{

    public Response getVet() {
        return getBasicRestConfig()
                .contentType(ContentType.JSON)
                .get("/api/vets");
    }

    public Response createVet(Vet vet) {
        return getBasicRestConfig()
                .contentType(ContentType.JSON)
                .body(vet)
                .post("/api/vets");
    }

    public Response deleteVet(Long vetId) {
        return getBasicRestConfig()
                .pathParam("vetId", vetId)
                .delete("api/vets/{vetId");
    }

    public Response getVetList() {
        return getBasicRestConfig()
                .get("api/vets");
    }
}
