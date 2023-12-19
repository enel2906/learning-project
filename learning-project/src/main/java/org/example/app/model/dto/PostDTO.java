package org.example.app.model.dto;

import java.util.List;

public class PostDTO {
    private String type;
    private String author;
    private String content;

    public PostDTO(String type, String author, String content) {
        this.type = type;
        this.author = author;
        this.content = content;
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

}
