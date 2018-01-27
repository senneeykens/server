package be.kul.dijleserver.util;

import be.kul.dijleserver.domain.Readings;

import java.time.LocalDateTime;
import java.time.ZoneOffset;

public class ReadingUtil {

    public static void fixTimestamps(Readings readings, LocalDateTime now) {

        final long nowUnix = now.toEpochSecond(ZoneOffset.UTC);
        final long timestampUnix = readings.getTimestamp().toEpochSecond(ZoneOffset.UTC);

        final long diffUnix = nowUnix - timestampUnix;

        readings.setTimestamp(
                LocalDateTime.ofEpochSecond(nowUnix, 0, ZoneOffset.UTC)
        );
        readings.getData()
                .forEach ( reading -> reading.setSamplingTimestamp(
                        LocalDateTime.ofEpochSecond(reading.getSamplingTimestamp().toEpochSecond(ZoneOffset.UTC) + diffUnix, 0, ZoneOffset.UTC)
                ));

    }

}
