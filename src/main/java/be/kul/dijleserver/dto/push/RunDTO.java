package be.kul.dijleserver.dto.push;

import be.kul.dijleserver.domain.RunType;

import java.util.List;

public class RunDTO {

    private long timestamp;
    private String name;
    private RunType type;
    private List<ReadingDTO> data;

    public long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(long timestamp) {
        this.timestamp = timestamp;
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

    public List<ReadingDTO> getData() {
        return data;
    }

    public void setData(List<ReadingDTO> data) {
        this.data = data;
    }

}
