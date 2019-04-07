package com.test.sample.screenplay_pattern.rest;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.rest.interactions.Get;
import net.thucydides.core.annotations.Step;

public class GetRequest implements Interaction {

    private final String resource;

    public GetRequest(String resource) {
        this.resource = resource;
    }

    @Override
    @Step("{0} attempts to send the get request")
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Get.resource(resource)
                        .with(requestSpecification -> requestSpecification.contentType("application/json")));
    }
}
