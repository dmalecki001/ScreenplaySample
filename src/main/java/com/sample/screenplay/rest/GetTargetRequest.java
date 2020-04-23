package com.sample.screenplay.rest;

import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.Tasks;

public class GetTargetRequest {

    public static Interaction andPostItTo(String resource, String body) {
        return Tasks.instrumented(PostRequest.class, resource, body);
    }

    public static Interaction andVerifyStatusCode(int code) {
        return Tasks.instrumented(VerifyStatusCode.class, code);
    }

    public static Interaction andSendItTo(String resource) {
        return Tasks.instrumented(GetRequest.class, resource);
    }
}
