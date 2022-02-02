package com.endava.petclinic.client;

import com.endava.petclinic.model.Visits;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class VisitsClient extends BaseClient {

    public Response getVisitsList() {
        return getBasicRestConfig()
                .get("api/visits");
    }

    public Response createVisit(Visits visits) {
        return getBasicRestConfig()
                .contentType(ContentType.JSON)
                .body(visits)
                .post("/api/visits");
    }

    public Response deleteVisits(Long visitId) {
        return getBasicRestConfig()
                .pathParam("visitId", visitId)
                .delete("api/visits/{visitId}");
    }
}
