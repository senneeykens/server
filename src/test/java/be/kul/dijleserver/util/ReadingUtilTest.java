package be.kul.dijleserver.util;

import be.kul.dijleserver.dto.push.ReadingDTO;
import be.kul.dijleserver.dto.push.RunDTO;
import org.junit.Test;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Arrays;
import java.util.List;

import static be.kul.dijleserver.util.ReadingUtil.millis;
import static be.kul.dijleserver.util.ReadingUtil.of;
import static org.junit.Assert.assertEquals;

public class ReadingUtilTest {

    @Test
    public void fixTimestamps() {

        final List<ReadingDTO> data = Arrays.asList(
                new ReadingDTO(timestamp(2014, 1, 6, 1), 1, 1, 1, 1),
                new ReadingDTO(timestamp(2014, 1, 6, 2), 1, 1, 1, 1),
                new ReadingDTO(timestamp(2014, 1, 6, 3), 1, 1, 1, 1),
                new ReadingDTO(timestamp(2014, 1, 6, 4), 1, 1, 1, 1),
                new ReadingDTO(timestamp(2014, 1, 6, 5), 1, 1, 1, 1)
        );

        final long now = timestamp(2018, 1, 27, 13);

        final RunDTO readings = new RunDTO();
        readings.setData(data);
        readings.setTimestamp(timestamp(2014, 1, 1, 1));

        ReadingUtil.fixTimestamps(readings, of(now));

        assertTimestamp ( readings.getTimestamp(), 1, 27, 13 );
        for ( int i = 0; i < readings.getData().size(); i ++ ) {
            assertTimestamp ( readings.getData().get(i).getSamplingTimestamp(), 2, 1, i + 13 );
        }

    }

    private void assertTimestamp(long timestampAsMillis, int month, int day, int hour) {
        final LocalDateTime timestamp = of(timestampAsMillis);
        assertEquals ( 2018, timestamp.getYear() );
        assertEquals ( month, timestamp.getMonthValue() );
        assertEquals ( day, timestamp.getDayOfMonth() );
        assertEquals ( hour, timestamp.getHour() );
    }

    private long timestamp(int year, int month, int day, int hour) {
        return millis(LocalDateTime.of(LocalDate.of(year, month, day), LocalTime.of(hour, 0)));
    }

}