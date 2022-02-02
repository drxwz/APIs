package com.endava.petclinic.pettype;

import com.endava.petclinic.TestBaseClass;
import com.endava.petclinic.model.PetType;
import io.restassured.response.Response;
import org.apache.http.HttpStatus;
import org.junit.jupiter.api.Test;

public class DeletePetTypeTest extends TestBaseClass {

    @Test
    public void shouldDeletePetTypeById() {

        //GIVEN
        fixture.createOwner().createPetType().createPet();
        PetType petType = fixture.getPetType();

        //WHEN
        Response response = petTypeClient.deletePetType(petType.getId());

        //THEN
        response.then().statusCode(HttpStatus.SC_NO_CONTENT);
    }
}
