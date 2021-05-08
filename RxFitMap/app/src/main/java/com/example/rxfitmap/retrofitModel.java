package com.example.rxfitmap;

import org.w3c.dom.ls.LSInput;

import java.util.List;

class Post {

    int postId;
    int id;
    String body;
    List<String> name;

    public Post(int postId, int id, String body, List<String> name) {

        this.postId = postId;
        this.id = id;
        this.body = body;
        this.name = name;
    }

    public int getPostId() {
        return postId;
    }

    public int getId() {
        return id;
    }

    public String getBody() {
        return body;
    }

    public List<String> getName() {
        return name;
    }

    public void setPostId(int postId) {
        this.postId = postId;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public void setName(List<String> name) {
        this.name = name;
    }
}
