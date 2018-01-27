package be.kul.dijleserver.domain;

import java.time.LocalDateTime;
import java.util.List;

public class Readings {

    private LocalDateTime timestamp;
    private List<Reading> data;

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }

    public List<Reading> getData() {
        return data;
    }

    public void setData(List<Reading> data) {
        this.data = data;
    }

}
