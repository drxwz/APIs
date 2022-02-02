package com.endava.petclinic.testData;

import com.endava.petclinic.model.Owner;
import com.endava.petclinic.model.Pet;
import com.endava.petclinic.model.PetType;
import com.endava.petclinic.model.Visits;
import com.github.javafaker.Faker;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class TestDataProvider {

    private final Faker faker = new Faker();

    public Owner getOwner() {
        Owner owner = new Owner();

        owner.setFirstName(faker.name().firstName());
        owner.setLastName(faker.name().lastName());
        owner.setAddress(faker.address().fullAddress());
        owner.setCity(faker.address().city());
        owner.setTelephone(faker.number().digits(faker.number().numberBetween(1, 9)));

        return owner;
    }

    public String getNumberWithDigits(int min, int max) {
        return faker.number().digits(faker.number().numberBetween(min, max));
    }

    public Pet getPet(Owner owner, PetType type) {
        String birthDate = faker.date().birthday().toInstant().atZone(ZoneId.systemDefault()).format(DateTimeFormatter.ofPattern("yyy/MM/dd"));

        Pet pet = new Pet();

        pet.setName(faker.artist().name());
        pet.setBirthDate(birthDate);
        pet.setOwner(owner);
        pet.setType(type);

        return pet;
    }

    public PetType getPetType() {
        PetType type = new PetType();

        type.setName(faker.animal().name());

        return type;
    }

    public Visits getVisits(Pet pet) {
        Date now = new Date();
        Visits visits = new Visits();

        visits.setDescription(faker.chuckNorris().fact());
        visits.setName(faker.lorem().sentence());
        visits.setVisitDate(faker.date().future(1000, TimeUnit.DAYS).toString());

        return visits;
    }
}
