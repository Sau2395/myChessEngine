package com.saurabh.mychessengine;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MyChessEngineApplication {

    public static void main(String[] args) {

        //SpringApplication.run(MyChessEngineApplication.class, args);
        Player One  = new Player("w");
        Player Two = new Player("b");

        Game g = new Game(One, Two);
        g.setGame("rnbqkbnr/pp1ppppp/8/2p5/4P3/5N2/PPPP1PPP/RNBQKB1R b KQkq - 1 2");
        g.getBoard().display();

        System.out.println("Castling Available  : "+ g.isCastlingAvailable());
        System.out.println("En passant Move : "+ g.getEn_passant());
        System.out.println("Half Moves : "+ g.getHalfMoves() + " played so far..");
        System.out.println("Total Moves : "+ g.getPlayedMoves() + " played so far..");
        System.out.println("Player : "+ g.getCurrentTurn().getColor() + " plays next..");
        System.out.println("Possible Valid Moves : " + g.getBoard().getValidMovesCount());
    }

}
