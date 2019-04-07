package com.test.sample.screenplay_pattern.rest;

import com.test.sample.screenplay_pattern.jsons.JsonInstance;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.Tasks;

public class GetTargetRequest {

    public static Interaction andPostItTo(String resource, JsonInstance instance){
        return Tasks.instrumented(PostRequest.class, resource, instance);
    }

    public static Interaction andVerifyStatusCode(int code) {
        return Tasks.instrumented(VerifyStatusCode.class, code);
    }

    public static Interaction andSendItTo(String resource){
        return Tasks.instrumented(GetRequest.class, resource);
    }
}
