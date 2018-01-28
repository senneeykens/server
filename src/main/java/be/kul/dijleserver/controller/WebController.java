package be.kul.dijleserver.controller;

import be.kul.dijleserver.dto.web.RunDTO;
import be.kul.dijleserver.repository.RunRepository;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

import static java.util.stream.Collectors.toList;

@Controller
@RequestMapping("/")
public class WebController {

    @Value("${google.api.key}")
    private String apikey;

    private RunRepository runRepository;

    public WebController(RunRepository runRepository) {
        this.runRepository = runRepository;
    }

    @GetMapping
    public String homepage() {
        return "/homepage";
    }

    @GetMapping("/run/{name}/{type}/graph")
    public String podGraph(@PathVariable("name") String name, @PathVariable("type") String type, Model model) {
        model.addAttribute("name", name);
        model.addAttribute("type", type);
        return "/run-graph";
    }

    @GetMapping("/run/{name}/{type}/map")
    public String podMap(@PathVariable("name") String name, @PathVariable("type") String type, Model model) {
        model.addAttribute("name", name);
        model.addAttribute("type", type);
        model.addAttribute("apikey", apikey);
        return "/run-map";
    }

    @ModelAttribute("runs")
    public List<RunDTO> runs() {
        return runRepository.findAll()
                .stream()
                .map(RunDTO::of)
                .sorted( (a, b) -> a.getName().compareToIgnoreCase(b.getName()))
                .collect(toList());
    }

}