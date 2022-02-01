package com.endava.petclinic.pet;

import com.endava.petclinic.TestBaseClass;
import com.endava.petclinic.model.Owner;
import com.endava.petclinic.model.Pet;
import com.endava.petclinic.model.PetType;
import io.restassured.response.Response;
import org.apache.http.HttpStatus;
import org.junit.jupiter.api.Test;

public class DeletePetTest extends TestBaseClass {

    @Test
    public void shouldDeletePetById() {

        //GIVEN
        Owner owner = testDataProvider.getOwner();
        Response createOwnerResponse = ownerClient.createOwner(owner);
        Long ownerID = createOwnerResponse.body().jsonPath().getLong("id");
        owner.setId(ownerID);
        createOwnerResponse.then()
                .statusCode(HttpStatus.SC_CREATED);

        PetType type = new PetType();
        type.setId(1L);

        Pet pet = testDataProvider.getPet(owner, type);
        Response createPetResponse = petClient.createPet(pet);
        createPetResponse.then()
                .statusCode(HttpStatus.SC_CREATED);
        Long petId = createPetResponse.body().jsonPath().getLong("id");

        //WHEN
        Response response = petClient.deletePet(petId);

        //THEN
        response.then().statusCode(HttpStatus.SC_NO_CONTENT);
    }


}
