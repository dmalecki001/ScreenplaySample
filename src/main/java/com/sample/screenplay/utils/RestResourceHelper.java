package com.sample.screenplay.utils;

import net.serenitybdd.screenplay.actors.OnStage;

public class RestResourceHelper {

    public static String getFullResource(String resource) {
        if (resource.equalsIgnoreCase(KeyData.POST_USER_ID.getName())) {
            return resource + OnStage.theActorInTheSpotlight().recall(KeyData.HIGHEST_USER_ID.getName());
        } else {
            throw new UnsupportedOperationException("REST RESOURCE NOT RECOGNIZED");
        }
    }

}
