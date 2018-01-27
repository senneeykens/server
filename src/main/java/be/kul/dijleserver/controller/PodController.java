package be.kul.dijleserver.controller;

import be.kul.dijleserver.domain.Reading;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController()
@RequestMapping("/pod")
public class PodController {

    @PostMapping()
    public ResponseEntity<String> message ( @RequestBody Reading reading ) {
        System.out.println ( reading );
        return ResponseEntity.ok("Reading accepted");
    }
}
