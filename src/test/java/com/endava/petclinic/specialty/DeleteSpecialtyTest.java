package com.endava.petclinic.specialty;

import com.endava.petclinic.TestBaseClass;
import com.endava.petclinic.fixture.PetclinicFixture;
import com.endava.petclinic.model.Specialty;
import io.restassured.response.Response;
import org.apache.http.HttpStatus;
import org.junit.jupiter.api.Test;

public class DeleteSpecialtyTest extends TestBaseClass {

    @Test
    public void shouldDeleteSpecialty(){
        //GIVEN
        fixture.createSpecialty();
        Specialty specialty = fixture.getSpecialty();

        //WHEN
        Response response = specialtyClient.deleteSpecialtyById(specialty.getId());

        //THEN
        response.then().statusCode(HttpStatus.SC_NO_CONTENT);
    }
}
