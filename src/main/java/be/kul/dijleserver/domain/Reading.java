package be.kul.dijleserver.domain;

import java.time.LocalDateTime;

public class Reading {

    private LocalDateTime samplingTimestamp;
    private double temperature;
    private double turbidity;
    private double disolvedOxygen;

    public Reading() {
    }

    public Reading(LocalDateTime samplingTimestamp, double temperature, double turbidity, double disolvedOxygen) {
        this.samplingTimestamp = samplingTimestamp;
        this.temperature = temperature;
        this.turbidity = turbidity;
        this.disolvedOxygen = disolvedOxygen;
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

    @Override
    public String toString() {
        return "Reading{" +
                "temperature=" + temperature +
                ", turbidity=" + turbidity +
                ", disolvedOxygen=" + disolvedOxygen +
                '}';
    }

}