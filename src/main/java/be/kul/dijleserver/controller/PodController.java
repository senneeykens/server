package be.kul.dijleserver.controller;

import be.kul.dijleserver.repository.ReadingRepository;
import be.kul.dijleserver.domain.Readings;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

import static be.kul.dijleserver.util.ReadingUtil.fixTimestamps;

@RestController()
@RequestMapping("/pod")
public class PodController {

    private ReadingRepository readingRepository;

    @PostMapping()
    public ResponseEntity<String> message ( @RequestBody Readings readings ) {

        fixTimestamps ( readings, LocalDateTime.now() );

        readings.getData().forEach( reading -> readingRepository.add(reading));

        return ResponseEntity.ok("Reading accepted");
    }

}
