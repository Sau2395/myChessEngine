package com.saurabh.mychessengine;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MyChessEngineApplication {

    public static void main(String[] args) {

        //SpringApplication.run(MyChessEngineApplication.class, args);
        Game g = new Game();
        g.getBoard().display();

        System.out.println("Possible Valid Moves : " + g.getBoard().getValidMovesCount());
    }

}
