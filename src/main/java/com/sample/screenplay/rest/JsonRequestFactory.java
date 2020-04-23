package com.sample.screenplay.rest;

public class JsonRequestFactory {

    public static JsonRequest provideRequest(JsonStrategy strategy) {
        return new JsonRequestSupplier().supplyValue(strategy);
    }

}
