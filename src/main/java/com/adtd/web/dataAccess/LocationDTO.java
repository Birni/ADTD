package com.adtd.web.dataAccess;

public class LocationDTO {

    private String name;
    private String  identifier;

    public LocationDTO() {

    }

    public LocationDTO (String name, String identifier)
    {
        this.name = name;
        this.identifier = identifier;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        name = name;
    }

    public String getIdentifier() {
        return identifier;
    }

    public void setIdentifier(String identifier) {
        this.identifier = identifier;
    }
}