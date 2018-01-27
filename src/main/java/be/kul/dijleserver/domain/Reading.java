package be.kul.dijleserver.domain;

public class Reading {

    private float temperature;
    private float turbidity;
    private float disolvedOxygen;

    public float getTemperature() {
        return temperature;
    }

    public void setTemperature(float temperature) {
        this.temperature = temperature;
    }

    public float getTurbidity() {
        return turbidity;
    }

    public void setTurbidity(float turbidity) {
        this.turbidity = turbidity;
    }

    public float getDisolvedOxygen() {
        return disolvedOxygen;
    }

    public void setDisolvedOxygen(float disolvedOxygen) {
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