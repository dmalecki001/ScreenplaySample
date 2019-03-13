package com.test.sample.utils;

import com.test.sample.screenplay_pattern.jsons.JsonInstance;
import com.test.sample.screenplay_pattern.jsons.PostId;

import java.util.List;
import java.util.stream.Collectors;

public class TestDataManager {

    private static final PropertiesReader reader = new PropertiesReader(SampleProperties.getSampleProperties());

    public static PropertiesReader getReader(){
        return reader;
    }

    public static String getHighestValueFromIntegerList(List<Integer> list){
        return String.valueOf(list.stream().collect(Collectors.summarizingInt(Integer::intValue)).getMax());
    }

    public static JsonInstance getNewPostId(){
        return new PostId();
    }

    public static String getGuiEmail(){
        return reader.readSpecificProperty("guiEmail");
    }

    public static String getGuiPassword(){
        return reader.readSpecificProperty("guiPassword");
    }

}
