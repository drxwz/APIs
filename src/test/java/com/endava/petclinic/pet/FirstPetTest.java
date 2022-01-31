package com.endava.petclinic.pet;


import org.apache.http.HttpStatus;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;


public class FirstPetTest {

    @Test
    public void firstTest() {

        given()
                .baseUri("http://bhdtest.endava.com")
                .port(8080)
                .basePath("petclinic")
                .log().all()
                .when()
                .get("api/pets")
                .prettyPeek()
                .then()
                .statusCode(HttpStatus.SC_OK);
    }

//    @Test
//    public void createPet() {
//        //GIVEN
//        Pet pet = new Pet("Ionut", "25.01.1991", new Owner() );
//
//        //WHEN
//        Response response = given()
//                .baseUri("http://bhdtest.endava.com")
//                .port(8080)
//                .basePath("petclinic")
//                .contentType(ContentType.JSON)
//                .body(pet)
//                .log().all()
//                .when()
//                .post("api/pets")
//                .prettyPeek();
//
//        //THEN
//        response.then()
//                .statusCode(HttpStatus.SC_CREATED)
//                .header("Location", notNullValue())
//                .body("id", notNullValue())
//                .body("firstName", is(pet.getName()));
//
//
//        Owner actualOwner = response.as(Owner.class);
//
//        assertThat(actualOwner, is(pet));
//    }
}
