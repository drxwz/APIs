package com.endava.petclinic.visits;

import com.endava.petclinic.TestBaseClass;
import com.endava.petclinic.model.Visits;
import io.restassured.response.Response;
import org.apache.http.HttpStatus;
import org.junit.jupiter.api.Test;

public class CreateVisitsTest extends TestBaseClass {

    @Test
    public void shouldCreateVisit() {
        //GIVEN
        fixture.createOwner().createPetType().createPet();
        Visits visits = fixture.createVisits().getVisits();

        //WHEN
        Response response = visitsClient.createVisit(visits);

        //THEN
        response.then().statusCode(HttpStatus.SC_CREATED);
    }
}
