package org.example.app.model;

import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.List;

import static org.example.app.constant.PostType.*;

@Document(collection = "posts")
public class Post {
    @Id
    private String id;
    private String userId;
    private String author;



    public Post(String id, String userId, String author, String content, String type) {
        this.id = id;
        this.userId = userId;
        this.author = author;
        this.content = content;
        this.type = type;
    }

    public Post(String userId, String author, String content, String type) {
        this.userId = userId;
        this.author = author;
        this.content = content;
        this.type = type;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    private String content;

    private String type;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }


    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

}
