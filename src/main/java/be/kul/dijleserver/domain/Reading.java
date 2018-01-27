package be.kul.dijleserver.domain;

import be.kul.dijleserver.dto.ReadingDTO;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Entity
@Table(name = "tbl_reading")
public class Reading extends AbstractBaseObject {

    @NotNull
    @Column
    private LocalDateTime samplingTimestamp;

    @NotNull
    @Column
    private double temperature;

    @NotNull
    @Column
    private double turbidity;

    @NotNull
    @Column
    private double disolvedOxygen;

    @NotNull
    @Column
    private double flowRate;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "pod_id")
    private Pod pod;

    public Reading() {
    }

    public Reading(LocalDateTime samplingTimestamp, double temperature, double turbidity, double disolvedOxygen, double flowRate) {
        this.samplingTimestamp = samplingTimestamp;
        this.temperature = temperature;
        this.turbidity = turbidity;
        this.disolvedOxygen = disolvedOxygen;
        this.flowRate = flowRate;
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

    public Pod getPod() {
        return pod;
    }

    public void setPod(Pod pod) {
        this.pod = pod;
    }

    @Override
    public String toString() {
        return "Reading{" +
                "samplingTimestamp=" + samplingTimestamp +
                ", temperature=" + temperature +
                ", turbidity=" + turbidity +
                ", disolvedOxygen=" + disolvedOxygen +
                ", flowRate=" + flowRate +
                ", pod=" + pod +
                '}';
    }

    public static Reading of(ReadingDTO dto) {
        final Reading reading = new Reading();
        reading.setSamplingTimestamp(dto.getSamplingTimestamp());
        reading.setTemperature(dto.getTemperature());
        reading.setTurbidity(dto.getTurbidity());
        reading.setDisolvedOxygen(dto.getDisolvedOxygen());
        reading.setFlowRate(dto.getFlowRate());
        return reading;
    }
}