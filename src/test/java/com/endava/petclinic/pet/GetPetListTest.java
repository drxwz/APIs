package com.endava.petclinic.pet;

import com.endava.petclinic.TestBaseClass;
import com.endava.petclinic.model.Pet;
import io.restassured.response.Response;
import org.apache.http.HttpStatus;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.withArgs;
import static org.hamcrest.Matchers.is;

public class GetPetListTest extends TestBaseClass {
    @Test
    public void shouldGetPetList() {
        //GIVEN
        fixture.createOwner().createPetType().createPet();
        Pet pet = fixture.getPet();

        //WHEN
        Response response = petClient.getPetList();

        //THEN
        response.then().statusCode(HttpStatus.SC_OK)
                .body("find{ it -> it.id == %s}.name",
                        withArgs(pet.getId()), is(pet.getName()));
    }
}
