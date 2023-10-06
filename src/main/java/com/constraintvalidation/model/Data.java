package com.constraintvalidation.model;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;

import java.util.LinkedHashMap;
import java.util.Map;

public class Data {

    private String name;
    private String add;
    @JsonAnyGetter
    private Map<String, Object> properties;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAdd() {
        return add;
    }

    public void setAdd(String add) {
        this.add = add;
    }

    public Map<String, Object> getProperties() {
        return properties;
    }

    public void setProperties(Map<String, Object> properties) {
        this.properties = properties;
    }

    //@JsonAnySetter
    public void setProperty(String t, Object o) {
        this.properties = this.properties == null ? new LinkedHashMap<>() : this.properties;
        this.properties.put(t, o);
    }
}
