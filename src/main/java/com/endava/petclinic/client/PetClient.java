package com.endava.petclinic.client;

import com.endava.petclinic.filters.AuthenticationFilter;
import com.endava.petclinic.filters.LogFilter;
import com.endava.petclinic.model.Pet;
import com.github.javafaker.Faker;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static com.endava.petclinic.util.EnvReader.*;
import static io.restassured.RestAssured.given;

public class PetClient {

    private Faker faker = new Faker();
    public Response createPet(Pet pet) {

        return given().filters( new AuthenticationFilter(), new LogFilter())
                .baseUri(getBaseUri())
                .port(getPort())
                .basePath(getBasePath())
                .contentType(ContentType.JSON)
                .body(pet)
                .post("/api/pets");

    }
    public String getNumberWithDigits(int min, int max) {
        return faker.number().digits(faker.number().numberBetween(min, max));
    }

    public Response getPetById(Long petId) {

        return given().filters( new AuthenticationFilter(), new LogFilter())
                .baseUri(getBaseUri())
                .port(getPort())
                .basePath(getBasePath())
                .pathParam("petId", petId)
                .get("/api/pets/{petId}");
    }

    public Response getPetList() {
        return given().filters( new AuthenticationFilter(), new LogFilter())
                .baseUri(getBaseUri())
                .port(getPort())
                .basePath(getBasePath())
                .get("api/pets");

    }

    public Response deletePet(Long petId) {
        return given().filters( new AuthenticationFilter(), new LogFilter())
                .baseUri(getBaseUri())
                .port(getPort())
                .basePath(getBasePath())
                .pathParam("petId", petId)
                .delete("api/pets/{petId}");
    }

    public Response updatePetById(Long petId) {
        return given().filters( new AuthenticationFilter(), new LogFilter())
                .baseUri(getBaseUri())
                .port(getPort())
                .basePath(getBasePath())
                .pathParam("petId", petId)
                .body(petId)
                .contentType(ContentType.JSON)
                .put("api/pets/{petId");

    }
}

