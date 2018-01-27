package be.kul.dijleserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

@SpringBootApplication
@EnableAsync
public class DijleserverApplication {

	public static void main(String[] args) {
		SpringApplication.run(DijleserverApplication.class, args);
	}

}
