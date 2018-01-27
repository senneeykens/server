package be.kul.dijleserver.repository;

import be.kul.dijleserver.domain.Reading;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@Repository
public class ReadingRepository {

    private List<Reading> readings;

    @PostConstruct
    public void init() {
        readings = new ArrayList<>();
/*
        LocalDateTime start = LocalDateTime.of(LocalDate.of(2018, 1, 1), LocalTime.of(0, 0));

        for ( int i = 0; i < 2000; i ++ ) {
            readings.add ( new Reading(
                    start,
                    Math.random() * 10,
                    Math.random() * 10,
                    Math.random() * 10
            ));

            start = start.plusHours(1);
        }*/
    }

    public List<Reading> findAll() {
        return readings;
    }

    public void add(Reading reading) {
        readings.add(reading);
    }

}