package be.kul.dijleserver.controller;

import be.kul.dijleserver.ReadingRepository;
import be.kul.dijleserver.domain.Reading;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/api/v1")
public class ApiController {

    private ReadingRepository readingRepository;

    public ApiController(ReadingRepository readingRepository) {
        this.readingRepository = readingRepository;
    }

    @GetMapping("/readings")
    @ResponseBody
    public List<Reading> getAllReadings() {
        return readingRepository.findAll();
    }

}