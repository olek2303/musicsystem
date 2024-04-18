package dev.musicsystem.musicsystem;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories(basePackages = "dev.musicsystem.musicsystem.repositories")
public class MusicsystemApplication {

	private static final Logger log = LoggerFactory.getLogger(MusicsystemApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(MusicsystemApplication.class, args);
	}

}
