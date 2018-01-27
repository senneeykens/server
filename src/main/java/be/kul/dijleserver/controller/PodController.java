package be.kul.dijleserver.controller;

import be.kul.dijleserver.dto.ReadingsDTO;
import be.kul.dijleserver.service.ReadingService;
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

    private ReadingService readingService;

    public PodController(ReadingService readingService) {
        this.readingService = readingService;
    }

    @PostMapping()
    public ResponseEntity<String> message ( @RequestBody ReadingsDTO readings ) {

        fixTimestamps ( readings, LocalDateTime.now() );

        readings.getData()
                .forEach( reading -> readingService.add(reading));

        return ResponseEntity.ok("Reading accepted");
    }

}
