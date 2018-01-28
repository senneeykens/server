package be.kul.dijleserver.util;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JSR310Module;

import java.io.IOException;

public class JsonUtil {

    private static final ObjectMapper mapper;

    static {
        mapper = new ObjectMapper();
        mapper.registerModule(new JSR310Module());
        mapper.configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false);
        mapper.configure(SerializationFeature.INDENT_OUTPUT, true);
        mapper.configure(DeserializationFeature.USE_BIG_INTEGER_FOR_INTS, true);
        mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
    }

    /**
     * Converts an Object to a Json string.
     */
    public static String asJson ( Object o ) {
        try {
            return mapper.writeValueAsString(o);
        } catch ( IOException e ) {
            throw new JsonFormatException ( "Issue converting to json : " + e.getLocalizedMessage(), e );
        }
    }

    /**
     * Converts a Json string to an Object.
     */
    public static <T> T asObject(String json, Class<T> clazz) {
        try {
            return mapper.readValue(json, clazz);
        } catch ( IOException e ) {
            throw new JsonFormatException ( "Issue converting from json (" +json+ ") : " + e.getLocalizedMessage(), e );
        }
    }

}