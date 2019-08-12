package com.visitor.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.mongojack.ObjectId;


@JsonIgnoreProperties(ignoreUnknown = true)
public class Visitor {

    public static final String COLLECTION_NAME = "visitor";
    public static final String VISITOR_ID = "_id";
    public static final String NAME = "name";

    @ObjectId
    @JsonProperty(VISITOR_ID)
    private String visitorId;

    @JsonProperty(NAME)
    String name;

    public String getVisitorId() {
        return visitorId;
    }

    public void setVisitorId(String visitorId) {
        this.visitorId = visitorId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Visitor{" +
                "visitorId='" + visitorId + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
