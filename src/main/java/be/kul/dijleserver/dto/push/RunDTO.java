package be.kul.dijleserver.dto.push;

import be.kul.dijleserver.dto.AbstractRunDTO;

import java.util.List;

public class RunDTO extends AbstractRunDTO{

    private long timestamp;
    private List<ReadingDTO> data;

    public long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(long timestamp) {
        this.timestamp = timestamp;
    }

    public List<ReadingDTO> getData() {
        return data;
    }

    public void setData(List<ReadingDTO> data) {
        this.data = data;
    }

}
