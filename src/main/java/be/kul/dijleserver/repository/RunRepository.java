package be.kul.dijleserver.repository;

import be.kul.dijleserver.domain.Run;
import be.kul.dijleserver.domain.RunType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RunRepository extends JpaRepository<Run, String> {

    Run findByNameAndType(String name, RunType type);

}