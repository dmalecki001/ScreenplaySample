package com.test.sample.screenplay_pattern.jsons;

import com.google.gson.GsonBuilder;
import com.test.sample.utils.KeyData;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import net.serenitybdd.screenplay.actors.OnStage;
@Builder
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class PostId implements JsonInstance {

    public static PostId preSetPostId(){
        return new PostIdBuilder()
                .postId(OnStage.theActorInTheSpotlight().recall(KeyData.HIGHEST_ID.getName()))
                .id("501")
                .name("doloribus dolores ut dolores occaecati")
                .email("Dolly@mandy.co.uk")
                .body("non dolor consequatur laboriosam ut deserunt")
                .build();
    }

    private String postId;
    private String id;
    private String name;
    private String email;
    private String body;

    @Override
    public String getJson() {
        return new GsonBuilder()
                .setPrettyPrinting()
                .create()
                .toJson(this);
    }
}
