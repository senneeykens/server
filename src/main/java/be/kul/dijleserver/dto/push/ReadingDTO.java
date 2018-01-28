package be.kul.dijleserver.dto.push;

import be.kul.dijleserver.domain.Reading;

import java.time.LocalDateTime;

public class ReadingDTO {

    private LocalDateTime samplingTimestamp;
    private String pod;
    private double temperature;
    private double turbidity;
    private double disolvedOxygen;
    private double flowRate;

    public ReadingDTO() {
    }

    public ReadingDTO(LocalDateTime samplingTimestamp, String pod, double temperature, double turbidity, double disolvedOxygen, double flowRate) {
        this.samplingTimestamp = samplingTimestamp;
        this.pod = pod;
        this.temperature = temperature;
        this.turbidity = turbidity;
        this.disolvedOxygen = disolvedOxygen;
        this.flowRate = flowRate;
    }

    public String getPod() {
        return pod;
    }

    public void setPod(String pod) {
        this.pod = pod;
    }

    public LocalDateTime getSamplingTimestamp() {
        return samplingTimestamp;
    }

    public void setSamplingTimestamp(LocalDateTime samplingTimestamp) {
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

    public static ReadingDTO of(Reading reading) {
        final ReadingDTO dto = new ReadingDTO();
        dto.setSamplingTimestamp(reading.getSamplingTimestamp());
        dto.setDisolvedOxygen(reading.getDisolvedOxygen());
        dto.setFlowRate(reading.getFlowRate());
        dto.setTemperature(reading.getTemperature());
        dto.setTurbidity(reading.getTurbidity());
        return dto;
    }
}