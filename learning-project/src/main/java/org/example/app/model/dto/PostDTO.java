package org.example.app.model.dto;

import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.List;

@Document
public class PostDTO {
    @Id
    private String author;
    private String type;
    private String content;
    private long numLike;
    private List<UserDTO> listUserLiked;

    public long getNumLike() {
        return numLike;
    }

    public void setNumLike(long numLike) {
        this.numLike = numLike;
    }


    public PostDTO(String author, String type, String content) {
        this.type = type;
        this.author = author;
        this.content = content;
    }

    public List<UserDTO> getListUserLiked() {
        return listUserLiked;
    }

    public void setListUserLiked(List<UserDTO> listUserLiked) {
        this.listUserLiked = listUserLiked;
    }

    public PostDTO(String author, String type, String content, long numLike, List<UserDTO> listUserLiked) {
        this.author = author;
        this.type = type;
        this.content = content;
        this.numLike = numLike;
        this.listUserLiked = listUserLiked;
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
