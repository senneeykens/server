package be.kul.dijleserver.repository;

import be.kul.dijleserver.domain.Pod;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PodRepository extends JpaRepository<Pod, String> {

    Pod findByName(String name);

}