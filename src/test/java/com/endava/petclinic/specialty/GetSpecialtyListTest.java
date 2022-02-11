package com.endava.petclinic.specialty;

import com.endava.petclinic.TestBaseClass;
import com.endava.petclinic.model.Specialty;
import io.restassured.response.Response;
import org.apache.http.HttpStatus;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.withArgs;
import static org.hamcrest.Matchers.is;

public class GetSpecialtyListTest extends TestBaseClass {

    @Test
    public void shouldGetSpecialtyList(){
        //GIVEN
        fixture.createSpecialty();
        Specialty specialty = fixture.getSpecialty();

        //WHEN
        Response response = specialtyClient.getSpecialty();

        //THEN
        response.then().statusCode(HttpStatus.SC_OK)
                .body("find{ it -> it.id == %s}.name", withArgs(specialty.getId()),is(specialty.getName()));




    }
}
