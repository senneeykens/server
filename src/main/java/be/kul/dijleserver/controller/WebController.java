package be.kul.dijleserver.controller;

import be.kul.dijleserver.domain.Reading;
import be.kul.dijleserver.domain.Run;
import be.kul.dijleserver.domain.RunType;
import be.kul.dijleserver.dto.web.RunDTO;
import be.kul.dijleserver.repository.ReadingRepository;
import be.kul.dijleserver.repository.RunRepository;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Comparator;
import java.util.List;

import static java.util.stream.Collectors.toList;

@Controller
@RequestMapping("/")
public class WebController {

    @Value("${google.api.key}")
    private String apikey;

    private RunRepository runRepository;
    private ReadingRepository readingRepository;

    public WebController(RunRepository runRepository, ReadingRepository readingRepository) {
        this.runRepository = runRepository;
        this.readingRepository = readingRepository;
    }

    @GetMapping
    public String homepage() {
        return "/homepage";
    }

    @GetMapping("/admin")
    public String admin(Model model) {
        model.addAttribute("runs",
                runRepository.findAll()
                        .stream()
                        .map(RunDTO::of)
                        .collect(toList())
        );
        return "/admin";
    }

    @GetMapping("/admin/delete/run/{name}/{type}")
    public String admin(@PathVariable("name") String name, @PathVariable("type") String type, Model model) {
        final Run run = runRepository.findByNameAndType(name, RunType.valueOf(type));
        if ( run != null ) {
            readingRepository.delete(run.getReadings());
            runRepository.delete(run);
        }
        return "redirect:/admin";
    }

    @GetMapping("/run/{name}/{type}/data")
    public String runData(@PathVariable("name") String name, @PathVariable("type") String type, Model model) {
        model.addAttribute("name", name);
        model.addAttribute("type", type);
        model.addAttribute("readings",
                runRepository.findByNameAndType(name, RunType.valueOf(type))
                        .getReadings()
                        .stream()
                        .sorted(Comparator.comparing(Reading::getSamplingTimestamp).reversed())
                        .collect(toList())
        );
        return "/run-data";
    }

    @GetMapping("/run/{name}/{type}/graph")
    public String runGraph(@PathVariable("name") String name, @PathVariable("type") String type, Model model) {
        model.addAttribute("name", name);
        model.addAttribute("type", type);
        return "/run-graph";
    }

    @GetMapping("/run/{name}/{type}/map")
    public String runMap(@PathVariable("name") String name, @PathVariable("type") String type, Model model) {
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