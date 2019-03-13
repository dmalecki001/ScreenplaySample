package com.test.sample.screenplay_pattern.rest;

import com.test.sample.screenplay_pattern.jsons.JsonInstance;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.rest.interactions.Post;
import net.thucydides.core.annotations.Step;

public class PostRequest implements Interaction {

    private final String resource;
    private final JsonInstance body;

    public PostRequest(String resource, JsonInstance body) {
        this.resource = resource;
        this.body = body;
    }

    @Override
    @Step("{0} attempts to post the request")
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(Post.to(resource)
                .with(requestSpecification -> requestSpecification.contentType("application/json")
                        .body(body.getJson())));
    }

}
