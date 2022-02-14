package com.endava.petclinic.fixture;

import com.endava.petclinic.client.*;
import com.endava.petclinic.model.*;
import com.endava.petclinic.testData.TestDataProvider;
import io.restassured.response.Response;
import lombok.Getter;
import org.apache.http.HttpStatus;

import java.util.List;

public class PetclinicFixture {

    private OwnerClient ownerClient = new OwnerClient();
    private PetClient petClient = new PetClient();
    private TestDataProvider dataProvider = new TestDataProvider();
    private PetTypeClient petTypeClient = new PetTypeClient();
    private VisitsClient visitsClient = new VisitsClient();
    private SpecialtyClient specialtyClient = new SpecialtyClient();
    private VetClient vetClient = new VetClient();


    @Getter
    private Owner owner;
    @Getter
    private Pet pet;
    @Getter
    private PetType petType;
    @Getter
    private Visits visits;
    @Getter
    private Specialty specialty;
    @Getter
    private Vet vet;

    public PetclinicFixture createOwner() {

        owner = dataProvider.getOwner();
        Response response = ownerClient.createOwner(owner);
        response.then().statusCode(HttpStatus.SC_CREATED);

        Long id = response.body().jsonPath().getLong("id");
        owner.setId(id);

        return this;
    }

    public PetclinicFixture createPet() {

        pet = dataProvider.getPet(owner, petType);
        Response response = petClient.createPet(pet);
        response.then()
                .statusCode(HttpStatus.SC_CREATED);
        Long petId = response.body().jsonPath().getLong("id");
        pet.setId(petId);

        return this;
    }

    public PetclinicFixture createPetType() {
        petType = dataProvider.getPetType();
        Response petTypeResponse = petTypeClient.createPetType(petType);
        petTypeResponse.then().statusCode(HttpStatus.SC_CREATED);
        Long petTypeId = petTypeResponse.body().jsonPath().getLong("id");
        petType.setId(petTypeId);

        return this;
    }

    public PetclinicFixture createVisits() {
        visits = dataProvider.getVisits(pet);
        Response visitsResponse = visitsClient.createVisit(visits);
        visitsResponse.then().statusCode(HttpStatus.SC_CREATED);
        Long visitsId = visitsResponse.body().jsonPath().getLong("id");
        visits.setId(visitsId);

        return this;
    }

    public PetclinicFixture createSpecialty() {
        specialty = dataProvider.getSpecialty();
        Response specialtyResponse = specialtyClient.createSpecialty(this.specialty);
        specialtyResponse.then().statusCode(HttpStatus.SC_CREATED);
        Long specialtyId = specialtyResponse.body().jsonPath().getLong("id");
        specialty.setId(specialtyId);

        return this;
    }

    public PetclinicFixture createVet() {
        vet = dataProvider.getVet(specialty);
        Response vetResponse = vetClient.createVet(this.vet);
        vetResponse.then().statusCode(HttpStatus.SC_CREATED);
        Long vetId = vetResponse.body().jsonPath().getLong("id");
        vet.setId(vetId);

        return this;
    }
}
