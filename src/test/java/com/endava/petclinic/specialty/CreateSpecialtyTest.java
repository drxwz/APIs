package com.endava.petclinic.specialty;

import com.endava.petclinic.TestBaseClass;
import com.endava.petclinic.model.Specialty;
import io.restassured.response.Response;
import org.apache.http.HttpStatus;
import org.junit.jupiter.api.Test;

import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.notNullValue;

public class CreateSpecialtyTest extends TestBaseClass {

        @Test
        public void shouldCreateSpecialty(){
            //GIVEN
            Specialty specialty = testDataProvider.getSpecialty();

            //WHEN
            Response response = specialtyClient.createSpecialty(specialty);

            //THEN
            response.then().statusCode(HttpStatus.SC_CREATED)
                    .body("id", is(notNullValue()));
        }





}
