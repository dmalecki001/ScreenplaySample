package com.sample.screenplay.rest;

import java.util.function.Consumer;

public class PostId {

    private String postId;
    private String id;
    private String name;
    private String email;
    private String body;

    private PostId(String postId, String id, String name, String email, String body) {
        this.postId = postId;
        this.id = id;
        this.name = name;
        this.email = email;
        this.body = body;
    }

    public static final class PostIdBuilder {

        public String postId;
        public String id;
        public String name;
        public String email;
        public String body;

        public PostIdBuilder with(Consumer<PostIdBuilder> builder) {
            builder.accept(this);
            return this;
        }

        public PostId build() {
            return new PostId(
                    this.postId,
                    this.id,
                    this.name,
                    this.email,
                    this.body
            );
        }

    }

}
