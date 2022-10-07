package br.com.study;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import br.com.study.model.Course;
import br.com.study.repository.CourseRepository;

@SpringBootApplication
public class CrudSpringApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(CrudSpringApiApplication.class, args);
	}

	@Bean
	CommandLineRunner initDB(CourseRepository courseRepository) {
		return args -> {
			courseRepository.deleteAll();
			
			Course c = new Course();
			c.setName("Angular with Spring");
			c.setCategory("front-end");
			courseRepository.save(c);
		};
	}
}
