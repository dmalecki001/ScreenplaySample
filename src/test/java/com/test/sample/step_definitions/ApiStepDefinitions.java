package com.test.sample.step_definitions;

import com.test.sample.screenplay_pattern.rest.GetDataFromRequest;
import com.test.sample.screenplay_pattern.rest.GetTargetRequest;
import com.test.sample.utils.TestDataGenerator;
import com.test.sample.utils.TestDataManager;
import cucumber.api.java8.En;
import net.serenitybdd.screenplay.rest.abilities.CallAnApi;

import static net.serenitybdd.screenplay.actors.OnStage.theActorCalled;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;

public class ApiStepDefinitions extends BaseDefinitions implements En {

    public ApiStepDefinitions() {

        Given("(.*) can call an api at its base rest service", (String actor) ->
                theActorCalled(actor).whoCan(CallAnApi.at(theRestApiBaseUrl)));

        When("(.*) sends a get request to resource \"([^\"]*)\"", (String actor, String resource) ->
                theActorCalled(actor).attemptsTo(GetTargetRequest.andSendIt(resource)));

        When("(.*) sends a get request to resource with data \"([^\"]*)\"", (String actor, String resource) ->
                theActorCalled(actor).attemptsTo(GetTargetRequest.andSendIt(resource + TestDataGenerator.getTestData().getHighestUserId())));

        Then("the status code should be (\\d+)", (Integer code) ->
            theActorInTheSpotlight().attemptsTo(GetTargetRequest.andVerifyStatusCode(code)));

        Then("(.*) should collect the userIds", (String actor) ->
            theActorCalled(actor).attemptsTo(GetDataFromRequest.andSaveUserIds()));

        Then("(.*) should collect the subIds", (String actor) ->
            theActorCalled(actor).attemptsTo(GetDataFromRequest.andSaveSubIds()));

        When("(.*) sends a post request to resource \"([^\"]*)\"", (String actor, String resource) ->
            theActorCalled(actor).attemptsTo(GetTargetRequest.andPostItTo(resource, TestDataManager.getNewPostId())));

    }
}
