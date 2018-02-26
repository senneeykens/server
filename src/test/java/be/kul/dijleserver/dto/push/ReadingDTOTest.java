package be.kul.dijleserver.dto.push;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ReadingDTOTest {

    @Test
    public void gpggaConversion() {

        final ReadingDTO readingDTO = new ReadingDTO();
        readingDTO.setGps("$GPRMC,204432.00,A,5111.59428,N,00432.82947,E,4.773,,250218,,,D*7E");

        assertEquals ( 51.115943, readingDTO.toReading().getLatitude(), 0.0 );
        assertEquals ( 04.328295, readingDTO.toReading().getLongtitude(), 0.0 );

    }

}