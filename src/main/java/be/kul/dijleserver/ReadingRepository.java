package be.kul.dijleserver;

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

        for ( int i = 0; i < 1000; i ++ ) {
            readings.add ( new Reading(
                    Math.random() * 10,
                    Math.random() * 10,
                    Math.random() * 10
            ) );
        }
    }

    public List<Reading> findAll() {
        return readings;
    }

}