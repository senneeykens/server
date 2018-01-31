package be.kul.dijleserver.dto;

public abstract class AbstractReadingDTO {

    private long samplingTimestamp;
    private double temperature;
    private double turbidity;
    private double disolvedOxygen;
    private double flowRate;

    public AbstractReadingDTO() {
    }

    public AbstractReadingDTO(long samplingTimestamp, double temperature, double turbidity, double disolvedOxygen, double flowRate) {
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

}
