package be.kul.dijleserver.dto.push;

import be.kul.dijleserver.domain.Reading;
import be.kul.dijleserver.util.ReadingUtil;

public class ReadingDTO {

    private long samplingTimestamp;
    private double temperature;
    private double turbidity;
    private double disolvedOxygen;
    private double flowRate;
    private double latitude;
    private double longtitude;

    public ReadingDTO() {
    }

    public ReadingDTO(long samplingTimestamp, double temperature, double turbidity, double disolvedOxygen, double flowRate) {
        this.samplingTimestamp = samplingTimestamp;
        this.temperature = temperature;
        this.turbidity = turbidity;
        this.disolvedOxygen = disolvedOxygen;
        this.flowRate = flowRate;
    }

    public long getSamplingTimestamp() {
        return samplingTimestamp;
    }

    public void setSamplingTimestamp(long samplingTimestamp) {
        this.samplingTimestamp = samplingTimestamp;
    }

    public double getTemperature() {
        return temperature;
    }

    public void setTemperature(double temperature) {
        this.temperature = temperature;
    }

    public double getTurbidity() {
        return turbidity;
    }

    public void setTurbidity(double turbidity) {
        this.turbidity = turbidity;
    }

    public double getDisolvedOxygen() {
        return disolvedOxygen;
    }

    public void setDisolvedOxygen(double disolvedOxygen) {
        this.disolvedOxygen = disolvedOxygen;
    }

    public double getFlowRate() {
        return flowRate;
    }

    public void setFlowRate(double flowRate) {
        this.flowRate = flowRate;
    }

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
        dto.setLatitude(50.878301);
        dto.setLongtitude(4.696478);
        return dto;
    }
}