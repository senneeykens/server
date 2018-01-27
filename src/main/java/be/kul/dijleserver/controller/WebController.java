package be.kul.dijleserver.controller;

import be.kul.dijleserver.dto.PodDTO;
import be.kul.dijleserver.repository.PodRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static java.util.stream.Collectors.toList;

@Controller
@RequestMapping("/")
public class WebController {

    private PodRepository podRepository;

    public WebController(PodRepository podRepository) {
        this.podRepository = podRepository;
    }

    @GetMapping
    public String homepage() {
        return "/homepage";
    }

    @GetMapping("/pod/{pod}")
    public String homepage(@PathVariable("pod") String pod, Model model) {

        model.addAttribute("pod", pod);

        return "/pod";
    }

    @ModelAttribute("pods")
    public List<PodDTO> pods() {
        return podRepository.findAll()
                .stream()
                .map(PodDTO::of)
                .sorted( (a, b) -> a.getName().compareToIgnoreCase(b.getName()))
                .collect(toList());
    }

}