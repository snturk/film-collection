package com.example.filmList;

import com.example.filmList.domain.Film;
import com.example.filmList.repository.FilmRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class FilmListApplication {

	public static void main(String[] args) {
		SpringApplication.run(FilmListApplication.class, args);
	}

}
