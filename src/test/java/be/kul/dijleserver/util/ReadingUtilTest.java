package be.kul.dijleserver.util;

import be.kul.dijleserver.domain.Reading;
import be.kul.dijleserver.domain.Readings;
import org.junit.Test;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class ReadingUtilTest {

    @Test
    public void fixTimestamps() {

        final List<Reading> data = Arrays.asList(
                new Reading(timestamp(2014, 1, 6, 1), 1, 1, 1),
                new Reading(timestamp(2014, 1, 6, 2), 1, 1, 1),
                new Reading(timestamp(2014, 1, 6, 3), 1, 1, 1),
                new Reading(timestamp(2014, 1, 6, 4), 1, 1, 1),
                new Reading(timestamp(2014, 1, 6, 5), 1, 1, 1)
        );

        final LocalDateTime now = timestamp(2018, 1, 27, 13);

        final Readings readings = new Readings();
        readings.setData(data);
        readings.setTimestamp(timestamp(2014, 1, 1, 1));

        ReadingUtil.fixTimestamps(readings, now);

        assertTimestamp ( readings.getTimestamp(), 1, 27, 13 );
        for ( int i = 0; i < readings.getData().size(); i ++ ) {
            assertTimestamp ( readings.getData().get(i).getSamplingTimestamp(), 2, 1, i + 13 );
        }

    }

    private void assertTimestamp(LocalDateTime timestamp, int month, int day, int hour) {
        assertEquals ( 2018, timestamp.getYear() );
        assertEquals ( month, timestamp.getMonthValue() );
        assertEquals ( day, timestamp.getDayOfMonth() );
        assertEquals ( hour, timestamp.getHour() );
    }

    private LocalDateTime timestamp(int year, int month, int day, int hour) {
        return LocalDateTime.of(LocalDate.of(year, month, day), LocalTime.of(hour, 0));
    }

}