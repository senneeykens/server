package be.kul.dijleserver.dto;

import be.kul.dijleserver.domain.Pod;

public class PodDTO {

    private String name;

    public PodDTO() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public static PodDTO of(Pod pod) {
        final PodDTO dto = new PodDTO();
        dto.setName(pod.getName());
        return dto;
    }
}