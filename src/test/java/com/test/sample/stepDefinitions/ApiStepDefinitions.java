package com.test.sample.stepDefinitions;

import com.sample.screenplay.rest.ApiRequests;
import com.sample.screenplay.rest.GetDataFromRequest;
import com.sample.screenplay.rest.GetTargetRequest;
import com.sample.screenplay.rest.JsonRequestFactory;
import cucumber.api.java8.En;
import net.serenitybdd.screenplay.rest.abilities.CallAnApi;

import static com.sample.screenplay.utils.RestResourceHelper.getFullResource;
import static net.serenitybdd.screenplay.actors.OnStage.theActorCalled;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;

public class ApiStepDefinitions extends BaseDefinitions implements En {

    public ApiStepDefinitions() {

        Given("(.*) can call an api at its base rest service", (String actor) ->
                theActorCalled(actor).whoCan(CallAnApi.at(theRestApiBaseUrl)));

        When("(.*) sends a get request to resource \"([^\"]*)\"", (String actor, String resource) ->
                theActorCalled(actor).attemptsTo(GetTargetRequest.andSendItTo(resource)));

        When("(.*) sends a get request to resource with data \"([^\"]*)\"", (String actor, String resource) ->
                theActorCalled(actor).attemptsTo(GetTargetRequest
                        .andSendItTo(getFullResource(resource))));

        Then("the status code should be (\\d+)", (Integer code) ->
                theActorInTheSpotlight().attemptsTo(GetTargetRequest.andVerifyStatusCode(code)));

        Then("(.*) should collect the userIds", (String actor) ->
                theActorCalled(actor).attemptsTo(GetDataFromRequest.andSaveUserIds()));

        Then("(.*) should collect the subIds", (String actor) ->
                theActorCalled(actor).attemptsTo(GetDataFromRequest.andSaveSubIds()));

        When("(.*) sends a post request to resource \"([^\"]*)\"", (String actor, String resource) ->
                theActorCalled(actor).attemptsTo(GetTargetRequest.andPostItTo(resource,
                        JsonRequestFactory.provideRequest(ApiRequests.POST_ID).jsonBody())));

    }
}
