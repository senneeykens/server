package be.kul.dijleserver.dto.push;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ReadingDTOTest {

    @Test
    public void gpggaConversion() {

        final ReadingDTO readingDTO = new ReadingDTO();
        readingDTO.setGpgga("$GPGGA,154653,4428.2011,N,00440.5161,W,0,00,,-00044.7,M,051.6,M,,*6C");

        assertEquals ( 44.282011, readingDTO.toReading().getLatitude(), 0.0 );
        assertEquals (  4.405161, readingDTO.toReading().getLongtitude(), 0.0 );

    }

}