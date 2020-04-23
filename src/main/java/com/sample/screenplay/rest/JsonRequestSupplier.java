package com.sample.screenplay.rest;

import java.util.stream.Stream;

public class JsonRequestSupplier {

    public JsonRequest supplyValue(JsonStrategy strategy) {
        return Stream.of(new PostIdRequest())
                .filter(request -> request.getStrategy().equals(strategy))
                .findFirst()
                .orElseThrow(() -> new UnsupportedOperationException(
                        String.format("Json request -> %s not recognised", strategy)));
    }


}
