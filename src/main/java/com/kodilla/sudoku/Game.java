package com.kodilla.sudoku;

import com.kodilla.sudoku.processor.GameProcessor;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Game {

    public static void main(String[] args) {
        GameProcessor processor = new GameProcessor();
        SpringApplication.run(Game.class, args);
        processor.run();
    }
}
