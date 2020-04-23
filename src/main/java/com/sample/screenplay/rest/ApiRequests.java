package com.sample.screenplay.rest;

public enum ApiRequests implements JsonStrategy {

    POST_ID;

    @Override
    public JsonStrategy getStrategy() {
        return this;
    }
}
