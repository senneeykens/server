package be.kul.dijleserver.domain;

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
    @Column(columnDefinition = "double precision")
    private double temperature;

    @NotNull
    @Column(columnDefinition = "double precision")
    private double turbidity;

    @NotNull
    @Column(columnDefinition = "double precision")
    private double disolvedOxygen;

    @NotNull
    @Column(columnDefinition = "double precision")
    private double flowRate;

    @Column(columnDefinition = "double precision")
    private double latitude;

    @Column(columnDefinition = "double precision")
    private double longtitude;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "run_id")
    private Run run;

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

    public Run getRun() {
        return run;
    }

    public void setRun(Run run) {
        this.run = run;
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

    @Override
    public String toString() {
        return "Reading{" +
                "samplingTimestamp=" + samplingTimestamp +
                ", temperature=" + temperature +
                ", turbidity=" + turbidity +
                ", disolvedOxygen=" + disolvedOxygen +
                ", flowRate=" + flowRate +
                ", run=" + run +
                '}';
    }

}