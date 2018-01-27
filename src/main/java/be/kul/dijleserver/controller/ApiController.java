package be.kul.dijleserver.controller;

import be.kul.dijleserver.domain.Pod;
import be.kul.dijleserver.dto.ReadingDTO;
import be.kul.dijleserver.repository.PodRepository;
import be.kul.dijleserver.repository.ReadingRepository;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

import static java.util.stream.Collectors.toList;

@Controller
@RequestMapping("/api/v1")
public class ApiController {

    private PodRepository podRepository;

    public ApiController(ReadingRepository readingRepository, PodRepository podRepository) {
        this.podRepository = podRepository;
    }

    @GetMapping("/pod/{pod}/readings")
    @ResponseBody
    public List<ReadingDTO> getAllReadings(@PathVariable("pod") String podName) {
        final Pod pod = podRepository.findByName(podName);
        return pod.getReadings()
                .stream()
                .map(ReadingDTO::of)
                .collect(toList());
    }

}