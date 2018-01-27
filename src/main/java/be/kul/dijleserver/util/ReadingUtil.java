package be.kul.dijleserver.util;

import be.kul.dijleserver.dto.ReadingsDTO;

import java.time.LocalDateTime;
import java.time.ZoneOffset;

public class ReadingUtil {

    public static void fixTimestamps(ReadingsDTO readings, LocalDateTime now) {

        final long nowUnix = millis(now);
        final long timestampUnix = millis(readings.getTimestamp());

        final long diffUnix = nowUnix - timestampUnix;

        readings.setTimestamp(
                LocalDateTime.ofEpochSecond(nowUnix, 0, ZoneOffset.UTC)
        );
        readings.getData()
                .forEach ( reading -> reading.setSamplingTimestamp(
                        LocalDateTime.ofEpochSecond(millis(reading.getSamplingTimestamp()) + diffUnix, 0, ZoneOffset.UTC)
                ));

    }

    private static long millis(LocalDateTime now) {
        return now.toEpochSecond(ZoneOffset.UTC);
    }

}