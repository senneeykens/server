package be.kul.dijleserver.dto.gmaps;

import java.util.HashMap;
import java.util.UUID;

public class Feature {

    private String id = UUID.randomUUID().toString();
    private String type = "Feature";
    private HashMap<String, Object> properties = new HashMap<>();
    private Geometry geometry;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public HashMap<String, Object> getProperties() {
        return properties;
    }

    public void setProperties(HashMap<String, Object> properties) {
        this.properties = properties;
    }

    public Geometry getGeometry() {
        return geometry;
    }

    public void setGeometry(Geometry geometry) {
        this.geometry = geometry;
    }
}
