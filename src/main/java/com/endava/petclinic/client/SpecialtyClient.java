package com.endava.petclinic.client;

import com.endava.petclinic.model.Specialty;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class SpecialtyClient extends BaseClient{

    public Response getSpecialty(){
        return getBasicRestConfig()
                .contentType(ContentType.JSON)
                .get("/api/specialties");
    }

    public Response createSpecialty(Specialty specialty) {
        return getBasicRestConfig()
                .contentType(ContentType.JSON)
                .body(specialty)
                .post("/api/specialties");
    }

    public Response deleteSpecialtyById(Long specialtyId){
        return getBasicRestConfig()
                .pathParam("specialtyId", specialtyId)
                .delete("/api/specialties/{specialtyId}");
    }
}
