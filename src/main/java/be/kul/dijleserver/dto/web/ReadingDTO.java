package be.kul.dijleserver.dto.web;

import be.kul.dijleserver.domain.Reading;
import be.kul.dijleserver.dto.AbstractReadingDTO;
import be.kul.dijleserver.util.ReadingUtil;

public class ReadingDTO extends AbstractReadingDTO {

    private double latitude;
    private double longtitude;

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLongtitude() {
        return longtitude;
    }

    public void setLongtitude(double longtitude) {
        this.longtitude = longtitude;
    }

    public static ReadingDTO of(Reading reading) {
        final ReadingDTO dto = new ReadingDTO();
        dto.setSamplingTimestamp(ReadingUtil.millis(reading.getSamplingTimestamp()));
        dto.setDisolvedOxygen(reading.getDisolvedOxygen());
        dto.setFlowRate(reading.getFlowRate());
        dto.setTemperature(reading.getTemperature());
        dto.setTurbidity(reading.getTurbidity());
        dto.setLatitude(reading.getLatitude());
        dto.setLongtitude(reading.getLongtitude());
        return dto;
    }
}