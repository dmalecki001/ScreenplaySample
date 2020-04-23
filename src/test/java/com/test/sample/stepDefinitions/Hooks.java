package com.test.sample.stepDefinitions;

import com.sample.screenplay.utils.*;
import cucumber.api.java8.En;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;

import static net.serenitybdd.screenplay.actors.OnStage.setTheStage;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;

public class Hooks extends BaseDefinitions implements En {

    public Hooks() {

        String[] cast = {"@Cast"};
        String[] dismiss = {"@Dismiss"};
        String[] serialize = {"@Serialize"};


        Before(this::setUp);
        Before(cast, () -> setTheStage(new OnlineCast()));

        After(serialize, () -> {
            theActorInTheSpotlight().remember(KeyData.ID.getName(), StringGenerators.randomId());
            Serializer.serialize(TestDataGenerator.getTestData(), TestDataManager.getPath());
        });

        After(TestDataGenerator::cleanDataPackage);
        After(dismiss, OnStage::drawTheCurtain);
    }

    private void setUp() {
        theRestApiBaseUrl = environmentVariables.optionalProperty("restapi.baseurl")
                .orElse("https://jsonplaceholder.typicode.com/");
        TestDataGenerator.getTestData().generateTestData();
    }
}
