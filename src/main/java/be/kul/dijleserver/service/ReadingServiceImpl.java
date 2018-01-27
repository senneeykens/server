package be.kul.dijleserver.service;

import be.kul.dijleserver.domain.Pod;
import be.kul.dijleserver.domain.Reading;
import be.kul.dijleserver.dto.ReadingDTO;
import be.kul.dijleserver.repository.PodRepository;
import be.kul.dijleserver.repository.ReadingRepository;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Service
public class ReadingServiceImpl implements ReadingService{

    private PodRepository podRepository;
    private ReadingRepository readingRepository;

    public ReadingServiceImpl(PodRepository podRepository, ReadingRepository readingRepository) {
        this.podRepository = podRepository;
        this.readingRepository = readingRepository;
    }

    @Async
    @Override
    public void add(ReadingDTO readingDTO) {

        Pod pod = podRepository.findByName(readingDTO.getPod());
        if ( pod == null ) {
            pod = new Pod();
            pod.setName(readingDTO.getPod());
            pod = podRepository.save(pod);
        }

        final Reading reading = Reading.of ( readingDTO );
        reading.setPod(pod);
        readingRepository.save ( reading );

    }

}