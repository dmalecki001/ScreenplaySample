package com.sample.screenplay.rest;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.rest.interactions.Post;
import net.thucydides.core.annotations.Step;

public class PostRequest implements Interaction {

    private final String resource;
    private final String body;

    public PostRequest(String resource, String body) {
        this.resource = resource;
        this.body = body;
    }

    @Override
    @Step("{0} attempts to post the request")
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(Post.to(resource)
                .with(requestSpecification -> requestSpecification.contentType("application/json")
                        .body(body)));
    }

}
