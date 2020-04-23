package com.sample.screenplay.rest;

import com.sample.screenplay.utils.KeyData;
import com.sample.screenplay.utils.TestDataManager;
import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Tasks;
import net.thucydides.core.annotations.Step;

import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;

public class GetDataFromRequest {

    public static Performable andSaveUserIds() {
        return Tasks.instrumented(CollectUserIds.class);
    }

    public static Performable andSaveSubIds() {
        return Tasks.instrumented(CollectSubIds.class);
    }

    class CollectUserIds implements Interaction {
        @Override
        @Step("{0} collects user ids")
        public <T extends Actor> void performAs(T actor) {
            theActorInTheSpotlight()
                    .remember(KeyData.HIGHEST_USER_ID.getName(),
                            TestDataManager.getHighestValueFromIntegerList(
                                    SerenityRest.lastResponse().then().extract().jsonPath().getList("userId")));
        }
    }

    class CollectSubIds implements Interaction {
        @Override
        @Step("{0} collects ids")
        public <T extends Actor> void performAs(T actor) {
            theActorInTheSpotlight()
                    .remember(KeyData.HIGHEST_ID.getName(),
                            TestDataManager.getHighestValueFromIntegerList(
                                    SerenityRest.lastResponse().then().extract().jsonPath().getList("id")));
        }
    }
}
