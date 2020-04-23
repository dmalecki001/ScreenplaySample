package com.sample.screenplay.rest;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public interface JsonRequest {

    Gson GSON = new GsonBuilder()
            .setPrettyPrinting()
            .create();

    <T> String jsonBody(T... dataHolder);

    default <T> String convertToJson(T object) {
        return GSON.toJson(object);
    }

}
