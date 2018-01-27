package be.kul.dijleserver.dto;

import java.time.LocalDateTime;
import java.util.List;

public class ReadingsDTO {

    private LocalDateTime timestamp;
    private List<ReadingDTO> data;

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }

    public List<ReadingDTO> getData() {
        return data;
    }

    public void setData(List<ReadingDTO> data) {
        this.data = data;
    }

}
