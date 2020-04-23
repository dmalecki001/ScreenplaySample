package com.sample.screenplay.utils;

public enum KeyData {

    COMMENTS("comments"),
    POST_USER_ID("posts?userId="),
    HIGHEST_USER_ID("highestUserId"),
    HIGHEST_ID("highestId"),
    ID("id");

    private String name;

    KeyData(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }
}
