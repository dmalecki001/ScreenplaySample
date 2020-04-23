package com.sample.screenplay.utils;

import net.serenitybdd.screenplay.actors.OnStage;

import java.util.List;
import java.util.stream.Collectors;

public class TestDataManager {

    private static final PropertiesReader reader = new PropertiesReader(SampleProperties.getSampleProperties());

    public static PropertiesReader getReader() {
        return reader;
    }

    public static String getHighestValueFromIntegerList(List<Integer> list) {
        return String.valueOf(list.stream().collect(Collectors.summarizingInt(Integer::intValue)).getMax());
    }

    public static TestDataGenerator getDeserializedData() {
        return Serializer.deserialize(getPath());
    }

    public static String getPath() {
        return "target/" + OnStage.theActorInTheSpotlight().recall(KeyData.ID.getName()) + "-data.txt";
    }

}
