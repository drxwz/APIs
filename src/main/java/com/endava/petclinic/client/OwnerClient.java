package com.endava.petclinic.client;

import com.endava.petclinic.model.Owner;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static com.endava.petclinic.util.EnvReader.getBasePath;

public class OwnerClient extends BaseClient {

    public Response createOwner(Owner owner) {
        return getBasicRestConfig()
                .contentType(ContentType.JSON)
                .body(owner)
                .post("/api/owners");
    }

    public Response getOwnerById(Long ownerId) {
        return getBasicRestConfig()
                .basePath(getBasePath())
                .pathParam("ownerId", ownerId)
                .get("/api/owners/{ownerId}");
    }

    public Response getOwnerList() {
        return getBasicRestConfig()
                .get("api/owners");
    }

    public Response deleteOwner(Long ownerId) {
        return getBasicRestConfig()
                .pathParam("ownerId", ownerId)
                .delete("api/owners/{ownerId}");
    }

    public Response updateOwnerById(Long ownerId) {
        return getBasicRestConfig()
                .pathParam("ownerId", ownerId)
                .body(ownerId)
                .contentType(ContentType.JSON)
                .put("api/owners/{ownerId");
    }
}
