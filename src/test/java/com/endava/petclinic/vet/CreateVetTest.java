package com.endava.petclinic.vet;

import com.endava.petclinic.TestBaseClass;
import com.endava.petclinic.model.Specialty;
import com.endava.petclinic.model.Vet;
import io.restassured.response.Response;
import org.apache.http.HttpStatus;
import org.junit.jupiter.api.Test;

public class CreateVetTest extends TestBaseClass {

    @Test
    public void shouldCreateVet() {
        //GIVEN
        fixture.createSpecialty();
        Specialty specialty = fixture.getSpecialty();
        Vet vet = testDataProvider.getVet(specialty);

        //WHEN
        Response response = vetClient.createVet(vet);

        //THEN
        response.then().statusCode(HttpStatus.SC_CREATED);
    }


}
