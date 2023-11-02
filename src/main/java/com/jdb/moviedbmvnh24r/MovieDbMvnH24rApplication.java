package com.jdb.moviedbmvnh24r;

import com.jdb.moviedbmvnh24r.service.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class MovieDbMvnH24rApplication {

    @Autowired
    private GameService gameService;

    public static void main(String[] args) {
        SpringApplication.run(MovieDbMvnH24rApplication.class, args);
    }


}
