package com.endava.petclinic.visits;

import com.endava.petclinic.TestBaseClass;
import com.endava.petclinic.model.Visits;
import io.restassured.response.Response;
import org.apache.http.HttpStatus;
import org.junit.jupiter.api.Test;

public class DeleteVisitsTest extends TestBaseClass {

    @Test
    public void shouldDeleteVisitById() {
        //GIVEN
        fixture.createOwner().createPetType().createPet();
        Visits visits = fixture.createVisits().getVisits();

        //WHEN
        Response response = visitsClient.deleteVisits(visits.getId());

        //THEN
        response.then().statusCode(HttpStatus.SC_NO_CONTENT);
    }
}
