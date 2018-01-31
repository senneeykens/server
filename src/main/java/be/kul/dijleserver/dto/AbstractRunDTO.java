package be.kul.dijleserver.dto;

import be.kul.dijleserver.domain.RunType;

public abstract class AbstractRunDTO {

    private String name;
    private RunType type;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public RunType getType() {
        return type;
    }

    public void setType(RunType type) {
        this.type = type;
    }

}