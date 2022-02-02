package com.endava.petclinic.pettype;

import com.endava.petclinic.TestBaseClass;
import com.endava.petclinic.model.PetType;
import io.restassured.response.Response;
import org.apache.http.HttpStatus;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.withArgs;
import static org.hamcrest.Matchers.is;

public class GetPetTypeListTest extends TestBaseClass {

    @Test
    public void shouldGetPetTypeList() {
        //GIVEN
        fixture.createOwner().createPetType().createPet();
        PetType petType = fixture.getPetType();

        //WHEN
        Response response = petTypeClient.getPetType();

        //THEN
        response.then().statusCode(HttpStatus.SC_OK)
                .body("find{ it -> it.id == %s}.name", withArgs(petType.getId()), is(petType.getName()));
    }
}
