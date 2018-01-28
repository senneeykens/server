package be.kul.dijleserver.dto.gmaps;

import java.util.ArrayList;
import java.util.List;

public class FeatureCollection {

    private String type = "FeatureCollection";
    private List<Feature> features = new ArrayList<>();

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public List<Feature> getFeatures() {
        return features;
    }

    public void setFeatures(List<Feature> features) {
        this.features = features;
    }

}