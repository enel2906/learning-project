package org.example.app.request.post;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.example.app.request.RequestData;

public class AddNewPostRequest extends RequestData {
    private String content;
    private String type;

    @JsonCreator
    public AddNewPostRequest(@JsonProperty("apiName") String apiName, @JsonProperty("content") String content, @JsonProperty("type") String type) {
        setApiName(apiName);
        this.content = content;
        this.type = type;
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
