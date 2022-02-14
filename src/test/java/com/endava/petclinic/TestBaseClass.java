package com.endava.petclinic;

import com.endava.petclinic.client.*;
import com.endava.petclinic.extension.TestReporterExtension;
import com.endava.petclinic.fixture.PetclinicFixture;
import com.endava.petclinic.services.DBService;
import com.endava.petclinic.testData.TestDataProvider;
import org.junit.jupiter.api.extension.ExtendWith;

@ExtendWith(TestReporterExtension.class)
public class TestBaseClass {

    protected OwnerClient ownerClient = new OwnerClient();
    protected TestDataProvider testDataProvider = new TestDataProvider();
    protected PetClient petClient = new PetClient();
    protected PetTypeClient petTypeClient = new PetTypeClient();
    protected VisitsClient visitsClient = new VisitsClient();
    protected SpecialtyClient specialtyClient = new SpecialtyClient();
    protected VetClient vetClient = new VetClient();

    protected PetclinicFixture fixture = new PetclinicFixture();

    protected DBService db = new DBService();
}
