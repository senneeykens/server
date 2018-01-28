package be.kul.dijleserver.util;

import be.kul.dijleserver.dto.push.RunDTO;

import java.time.LocalDateTime;
import java.time.ZoneOffset;

public class ReadingUtil {

    public static void fixTimestamps(RunDTO runDTO, LocalDateTime now) {

        final long nowUnix = millis(now);
        final long timestampUnix = millis(runDTO.getTimestamp());

        final long diffUnix = nowUnix - timestampUnix;

        runDTO.setTimestamp(
                LocalDateTime.ofEpochSecond(nowUnix, 0, ZoneOffset.UTC)
        );
        runDTO.getData()
                .forEach ( reading -> reading.setSamplingTimestamp(
                        LocalDateTime.ofEpochSecond(millis(reading.getSamplingTimestamp()) + diffUnix, 0, ZoneOffset.UTC)
                ));

    }

    private static long millis(LocalDateTime now) {
        return now.toEpochSecond(ZoneOffset.UTC);
    }

}