package be.kul.dijleserver.util;

import be.kul.dijleserver.dto.push.RunDTO;

import java.time.LocalDateTime;
import java.time.ZoneOffset;

public class ReadingUtil {

    public static void fixTimestamps(RunDTO runDTO, LocalDateTime now) {

        final long nowUnix = millis(now);
        final long timestampUnix = runDTO.getTimestamp();

        final long diffUnix = nowUnix - timestampUnix;

        runDTO.setTimestamp(nowUnix);
        runDTO.getData()
                .forEach ( reading -> reading.setSamplingTimestamp(reading.getSamplingTimestamp() + diffUnix) )
                ;
    }

    public static long millis(LocalDateTime now) {
        return now.toEpochSecond(ZoneOffset.UTC);
    }

    public static LocalDateTime of ( long millis ) {
        return LocalDateTime.ofEpochSecond(millis, 0, ZoneOffset.UTC);
    }

}