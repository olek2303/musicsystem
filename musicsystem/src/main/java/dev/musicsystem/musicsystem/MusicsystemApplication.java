package dev.musicsystem.musicsystem;

import dev.musicsystem.musicsystem.entity.Role;
import dev.musicsystem.musicsystem.repositories.RoleRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.scheduling.annotation.EnableAsync;

@SpringBootApplication
@EnableJpaAuditing
@EnableAsync
@EnableJpaRepositories(basePackages = "dev.musicsystem.musicsystem.repositories")
public class MusicsystemApplication {

	private static final Logger log = LoggerFactory.getLogger(MusicsystemApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(MusicsystemApplication.class, args);
	}

	@Bean
	public CommandLineRunner runner(RoleRepository roleRepository) {
		return args -> {
			if (roleRepository.findByName("USER").isEmpty()) {
				roleRepository.save(Role.builder().name("USER").build());
				roleRepository.save(Role.builder().name("ADMIN").build());
			}
		};
	}

}
