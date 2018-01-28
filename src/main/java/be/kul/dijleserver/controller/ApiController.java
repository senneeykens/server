package be.kul.dijleserver.controller;

import be.kul.dijleserver.domain.Run;
import be.kul.dijleserver.domain.RunType;
import be.kul.dijleserver.dto.gmaps.Feature;
import be.kul.dijleserver.dto.gmaps.FeatureCollection;
import be.kul.dijleserver.dto.gmaps.Geometry;
import be.kul.dijleserver.dto.push.ReadingDTO;
import be.kul.dijleserver.dto.push.RunDTO;
import be.kul.dijleserver.repository.RunRepository;
import be.kul.dijleserver.service.ReadingService;
import be.kul.dijleserver.util.JsonUtil;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

import static be.kul.dijleserver.util.ReadingUtil.fixTimestamps;
import static java.util.stream.Collectors.toList;

@Controller
@RequestMapping("/api/v1")
public class ApiController {

    private RunRepository runRepository;
    private ReadingService readingService;

    public ApiController(RunRepository runRepository, ReadingService readingService) {
        this.runRepository = runRepository;
        this.readingService = readingService;
    }

    @GetMapping("/run/{name}/{type}/readings")
    @ResponseBody
    public List<ReadingDTO> getAllReadings(@PathVariable("name") String name, @PathVariable("type") String type) {
        final Run run = runRepository.findByNameAndType(name, RunType.valueOf(type));
        return run.getReadings()
                .stream()
                .map(ReadingDTO::of)
                .collect(toList());
    }

    @GetMapping("/run/{name}/{type}/geometry")
    @ResponseBody
    public String getAllGeometry(@PathVariable("name") String name, @PathVariable("type") String type) {
        final FeatureCollection featureCollection = new FeatureCollection();

        runRepository.findByNameAndType(name, RunType.valueOf(type))
                .getReadings()
                .forEach( reading -> {
                    final Feature feature = new Feature();
                    featureCollection.getFeatures().add ( feature );

                    feature.setGeometry(new Geometry());

                    feature.getGeometry().getCoordinates().addAll(Arrays.asList(
                            -149.8072,
                            62.6916,
                            10.1
                    ));

                });

        return "eqfeed_callback(" + JsonUtil.asJson(featureCollection ) + ");";
    }

    @PostMapping("/reading")
    public ResponseEntity<String> message (@RequestBody RunDTO runDTO ) {

        fixTimestamps ( runDTO, LocalDateTime.now() );

        readingService.add(runDTO);

        return ResponseEntity.ok("Reading accepted");
    }

}