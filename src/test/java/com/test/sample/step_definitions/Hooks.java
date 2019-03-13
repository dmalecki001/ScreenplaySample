package com.test.sample.step_definitions;

import com.test.sample.utils.TestDataGenerator;
import com.test.sample.utils.TestDataManager;
import cucumber.api.java8.En;
import net.serenitybdd.screenplay.actors.OnlineCast;

import static net.serenitybdd.screenplay.actors.OnStage.setTheStage;

public class Hooks extends BaseDefinitions implements En {

    private void setUpGuiData() {
        setTheStage(new OnlineCast());
        TestDataGenerator.getTestData().generateTestData();
    }

    private void setUpApiData() {
        setTheStage(new OnlineCast());
        theRestApiBaseUrl = environmentVariables.optionalProperty("restapi.baseurl")
                .orElse("https://jsonplaceholder.typicode.com/");
        TestDataGenerator.getTestData().generateTestData();
    }

    private void saveGui(){
        TestDataManager.getReader().updateSpecificProperty("guiEmail", TestDataGenerator.getTestData().getNewEmailAddress());
        TestDataManager.getReader().updateSpecificProperty("guiPassword", TestDataGenerator.getTestData().getNewPassword());
    }

    public Hooks() {

        String[] apiTags = {"@API"};
        String[] guiTags = {"@GUI"};
        String[] saveGui = {"@SaveGui"};

        Before(apiTags, this::setUpApiData);

        Before(guiTags, this::setUpGuiData);

        After(saveGui, this::saveGui);
        After(guiTags, TestDataGenerator::cleanDataPackage);
        After(apiTags, TestDataGenerator::cleanDataPackage);

    }
}
