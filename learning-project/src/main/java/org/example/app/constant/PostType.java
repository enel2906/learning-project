package org.example.app.constant;

public enum PostType {
    RED("RED"),
    BLUE("BLUE"),
    GREEN("GREEN");

    private String type;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    PostType(String type) {
        this.type = type;
    }
}
