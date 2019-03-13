package com.test.sample.screenplay_pattern.jsons;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;
import com.test.sample.utils.TestDataGenerator;

public class PostId implements JsonInstance{

    private final JsonObject object = new JsonObject();
    private final Gson gson = new GsonBuilder().setPrettyPrinting().create();

    @Override
    public String getJson() {
        object.addProperty("postId", TestDataGenerator.getTestData().getHighestId());
        object.addProperty("id", 501);
        object.addProperty("name", "doloribus dolores ut dolores occaecati");
        object.addProperty("email", "Dolly@mandy.co.uk");
        object.addProperty("body", "non dolor consequatur laboriosam ut deserunt");
        return gson.toJson(object);
    }
}
