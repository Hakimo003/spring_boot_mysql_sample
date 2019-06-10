package com.example.easynotes;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class EasyNotesApplication {

       @Override
       protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
	return application.sources(EasyNotesApplication.class);
       }
	
	public static void main(String[] args) {
		SpringApplication.run(EasyNotesApplication.class, args);
	}
}
