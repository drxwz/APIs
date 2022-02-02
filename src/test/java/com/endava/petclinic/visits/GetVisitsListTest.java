package com.endava.petclinic.visits;

import com.endava.petclinic.TestBaseClass;
import com.endava.petclinic.model.Visits;
import io.restassured.response.Response;
import org.apache.http.HttpStatus;
import org.junit.jupiter.api.Test;

public class GetVisitsListTest extends TestBaseClass {

    @Test
    public void shouldGetVisitsList() {
        //GIVEN
        fixture.createOwner().createPetType().createPet();
        Visits visits = fixture.getVisits();

        //WHEN
        Response response = visitsClient.getVisitsList();

        //THEN
        response.then().statusCode(HttpStatus.SC_OK);
    }
}
