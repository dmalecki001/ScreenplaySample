package com.sample.screenplay.utils;

public class SampleProperties {

    private static SampleProperties.Properties
            sampleProperties = new SampleProperties.Properties();

    public static String getSampleProperties() {
        return sampleProperties.getPath();
    }


    private static class Properties {

        private static final String FILE_NAME = "sample.properties";
        private static final String RELATIVE_PATH = "src\\\\main\\\\resources\\\\properties\\\\";

        private String getPath() {
            return RELATIVE_PATH + FILE_NAME;
        }
    }

}
