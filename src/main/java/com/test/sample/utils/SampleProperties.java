package com.test.sample.utils;

public class SampleProperties {

    private static SampleProperties.Properties
            sampleProperties = new SampleProperties.Properties();

    public static String getSampleProperties(){
        return sampleProperties.getPath();
    }


    private static class Properties {

        private String fileName = "sample.properties";
        private String relative_path = "src\\\\main\\\\resources\\\\properties\\\\";

        private String getPath() {
            return relative_path + fileName;
        }
    }

}
