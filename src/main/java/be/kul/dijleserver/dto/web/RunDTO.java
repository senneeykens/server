package be.kul.dijleserver.dto.web;

import be.kul.dijleserver.domain.Run;
import be.kul.dijleserver.dto.AbstractRunDTO;

public class RunDTO extends AbstractRunDTO{

    public static RunDTO of(Run run) {
        final RunDTO dto = new RunDTO();
        dto.setName(run.getName());
        dto.setType(run.getType());
        return dto;
    }
}