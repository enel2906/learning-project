package org.example.app.model.dto;

import java.util.List;

public class PostDTO {
    private String type;
    private String author;
    private String content;
    private int numLike;
    private List<String> likedUsers;

    public List<String> getLikedUsers() {
        return likedUsers;
    }

    public void setLikedUsers(List<String> likedUsers) {
        this.likedUsers = likedUsers;
    }

    public int getNumLike() {
        return numLike;
    }

    public void setNumLike(int numLike) {
        this.numLike = numLike;
    }

    public PostDTO(String type, String author, String content,int numLike, List<String> likedUsers) {
        this.type = type;
        this.author = author;
        this.content = content;
        this.numLike = numLike;
        this.likedUsers = likedUsers;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public PostDTO(String type, String author, String content) {
        this.author = author;
        this.content = content;
        this.type = type;
    }
}
