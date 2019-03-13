package com.test.sample.screenplay_pattern.rest;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.thucydides.core.annotations.Step;

import static net.serenitybdd.screenplay.rest.questions.ResponseConsequence.seeThatResponse;

public class VerifyStatusCode implements Interaction {

    private final int code;

    public VerifyStatusCode(int code) {
        this.code = code;
    }

    @Override
    @Step("{0} verifies the status code")
    public <T extends Actor> void performAs(T actor) {
        actor.should(seeThatResponse(response -> response.statusCode(this.code)));
    }

}
