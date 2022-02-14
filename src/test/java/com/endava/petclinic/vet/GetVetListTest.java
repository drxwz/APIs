package com.endava.petclinic.vet;

import com.endava.petclinic.TestBaseClass;
import com.endava.petclinic.model.Vet;
import io.restassured.response.Response;
import org.apache.http.HttpStatus;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.withArgs;
import static org.hamcrest.Matchers.is;

public class GetVetListTest extends TestBaseClass {

    @Test
    public void shouldGetVetList() {

        //GIVEN
        fixture.createSpecialty().createVet();

        Vet vet = fixture.getVet();

        //WHEN
        Response response = vetClient.getVet();

        //THEN
        response.then().statusCode(HttpStatus.SC_OK)
                .body("find{ it -> it.id == %s}.firstName", withArgs(vet.getId()), is(vet.getFirstName()));
    }
}
