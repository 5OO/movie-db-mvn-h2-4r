package com.jdb.moviedbmvnh24r.startup;

import com.jdb.moviedbmvnh24r.service.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class GameCommandLineRunner implements CommandLineRunner {

    @Autowired
    private GameService gameService;

    @Override
    public void run(String... args) throws Exception {
        gameService.playGame();
    }
}
