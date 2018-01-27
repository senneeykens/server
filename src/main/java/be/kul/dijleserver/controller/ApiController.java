package be.kul.dijleserver.controller;

import be.kul.dijleserver.dto.ReadingDTO;
import be.kul.dijleserver.repository.ReadingRepository;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

import static java.util.stream.Collectors.toList;

@Controller
@RequestMapping("/api/v1")
public class ApiController {

    private ReadingRepository readingRepository;

    public ApiController(ReadingRepository readingRepository) {
        this.readingRepository = readingRepository;
    }

    @GetMapping("/readings")
    @ResponseBody
    public List<ReadingDTO> getAllReadings() {
        return readingRepository.findAll()
                .stream()
                .map(ReadingDTO::of)
                .collect(toList());
    }

}