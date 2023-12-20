package org.example.app.constant;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public enum PostType {
    RED("RED"),
    BLUE("BLUE"),
    GREEN("GREEN");

    public static final List<String> ListPostType = Arrays.asList(RED.getType(), BLUE.getType(), GREEN.getType());
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
