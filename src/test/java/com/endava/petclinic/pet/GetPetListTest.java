package com.endava.petclinic.pet;

import com.endava.petclinic.TestBaseClass;
import com.endava.petclinic.model.Owner;
import com.endava.petclinic.model.Pet;
import com.endava.petclinic.model.PetType;
import com.endava.petclinic.testData.TestDataProvider;
import io.restassured.response.Response;
import org.apache.http.HttpStatus;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.withArgs;
import static org.hamcrest.Matchers.is;

public class GetPetListTest extends TestBaseClass {
    @Test
    public void shouldGetPetList() {
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
        Response response = petClient.getPetList();


        //THEN

//1
        response.then().statusCode(HttpStatus.SC_OK)
                .body("find{ it -> it.id == %s}.name", withArgs(petId), is(pet.getName()));
    }
}
