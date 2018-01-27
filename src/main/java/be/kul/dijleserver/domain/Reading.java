package be.kul.dijleserver.domain;

public class Reading {

    private double temperature;
    private double turbidity;
    private double disolvedOxygen;

    public Reading() {
    }

    public Reading(double temperature, double turbidity, double disolvedOxygen) {
        this.temperature = temperature;
        this.turbidity = turbidity;
        this.disolvedOxygen = disolvedOxygen;
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