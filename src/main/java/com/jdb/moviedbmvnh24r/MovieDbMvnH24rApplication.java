package com.jdb.moviedbmvnh24r;

import com.jdb.moviedbmvnh24r.repository.MovieRepository;
import com.jdb.moviedbmvnh24r.service.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;


@SpringBootApplication
public class MovieDbMvnH24rApplication {

    @Autowired
    private GameService gameService;
    public static void main(String[] args) {
        SpringApplication.run(MovieDbMvnH24rApplication.class, args);
    }

    @Bean
    public CommandLineRunner runner(MovieRepository movieRepository) {
        return (args ->
                gameService.playGame());
    }


}
