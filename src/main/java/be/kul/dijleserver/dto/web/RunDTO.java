package be.kul.dijleserver.dto.web;

import be.kul.dijleserver.domain.Run;
import be.kul.dijleserver.domain.RunType;

public class RunDTO {

    private String name;
    private RunType type;

    public RunDTO() {
    }

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

    public static RunDTO of(Run run) {
        final RunDTO dto = new RunDTO();
        dto.setName(run.getName());
        dto.setType(run.getType());
        return dto;
    }
}