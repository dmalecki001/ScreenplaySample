package com.sample.screenplay.rest;

import com.sample.screenplay.utils.KeyData;
import net.serenitybdd.screenplay.actors.OnStage;

public class PostIdRequest implements JsonRequest, JsonStrategy {

    @Override
    public JsonStrategy getStrategy() {
        return ApiRequests.POST_ID;
    }

    @Override
    public <T> String jsonBody(T... dataHolder) {
        return convertToJson(new PostId
                .PostIdBuilder()
                .with(postIdBuilder -> {
                    postIdBuilder.postId = OnStage.theActorInTheSpotlight().recall(KeyData.HIGHEST_ID.getName());
                    postIdBuilder.id = "501";
                    postIdBuilder.name = "doloribus dolores ut dolores occaecati";
                    postIdBuilder.email = "Dolly@mandy.co.uk";
                    postIdBuilder.body = "non dolor consequatur laboriosam ut deserunt";
                }).build()
        );
    }

}
