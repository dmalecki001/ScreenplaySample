package com.test.sample.utils;

import com.test.sample.screenplay_pattern.jsons.JsonInstance;
import com.test.sample.screenplay_pattern.jsons.PostId;

public class JsonFactory {

    public static JsonInstance prepareJson(String resource) {
        if (resource.equalsIgnoreCase(KeyData.COMMENTS.getName())) {
            return PostId.preSetPostId();
        } else {
            throw new UnsupportedOperationException("RESOURCE NOT RECOGNIZED");
        }
    }

}
