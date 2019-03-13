package com.test.sample.screenplay_pattern.rest;

import com.test.sample.utils.TestDataGenerator;
import com.test.sample.utils.TestDataManager;
import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Tasks;
import net.thucydides.core.annotations.Step;

public class GetDataFromRequest {

    public static Performable andSaveUserIds(){
        return Tasks.instrumented(CollectUserIds.class);
    }

    public static Performable andSaveSubIds(){
        return Tasks.instrumented(CollectSubIds.class);
    }

    class CollectUserIds implements Interaction{
        @Override
        @Step("{0} collects user ids")
        public <T extends Actor> void performAs(T actor) {
            TestDataGenerator.getTestData().setUserIds(SerenityRest.then().extract().jsonPath().getList("userId"));
            TestDataManager.getReader().updateSpecificProperty("highestUserId", TestDataGenerator.getTestData().getHighestUserId());
        }
    }

    class CollectSubIds implements Interaction{
        @Override
        @Step("{0} collects ids")
        public <T extends Actor> void performAs(T actor) {
            TestDataGenerator.getTestData().setSubIds(SerenityRest.then().extract().jsonPath().getList("id"));
            TestDataManager.getReader().updateSpecificProperty("highestId",
                    TestDataManager.getHighestValueFromIntegerList(TestDataGenerator.getTestData().getSubIds()));
        }
    }
}
