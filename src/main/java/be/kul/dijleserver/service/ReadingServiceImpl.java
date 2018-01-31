package be.kul.dijleserver.service;

import be.kul.dijleserver.domain.Reading;
import be.kul.dijleserver.domain.Run;
import be.kul.dijleserver.dto.push.RunDTO;
import be.kul.dijleserver.repository.ReadingRepository;
import be.kul.dijleserver.repository.RunRepository;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ReadingServiceImpl implements ReadingService{

    private RunRepository runRepository;
    private ReadingRepository readingRepository;

    public ReadingServiceImpl(RunRepository runRepository, ReadingRepository readingRepository) {
        this.runRepository = runRepository;
        this.readingRepository = readingRepository;
    }

    @Async
    @Override
    @Transactional
    public void add(RunDTO dto) {

        Run run = runRepository.findByNameAndType(dto.getName(), dto.getType());
        if ( run == null ) {
            run = new Run();
            run.setName(dto.getName());
            run.setType(dto.getType());
            run = runRepository.save(run);
        }

        final Run savedRun = run;

        dto.getData()
                .forEach( readingDTO -> {
                    final Reading reading = readingDTO.toReading();
                    reading.setRun(savedRun);
                    readingRepository.save ( reading );
                });

    }

}