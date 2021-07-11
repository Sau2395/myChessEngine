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
        g.setGame("8/pp3P2/1P6/1P1R4/K1p1kN2/1P5q/1p2rn1b/8 b - - 0 1");
        g.getBoard().display();

        System.out.println("Castling Available  : "+ g.isCastlingAvailable());
        System.out.println("En passant Move : "+ g.getEn_passant());
        System.out.println("Half Moves : "+ g.getHalfMoves() + " played so far..");
        System.out.println("Total Moves : "+ g.getPlayedMoves() + " played so far..");
        System.out.println("Player : "+ g.getCurrentTurn().getColor() + " plays next..");
        System.out.println("Possible Valid Moves : " + g.getBoard().getValidMovesCount(true));
        System.out.println("Black Score : " + g.getBoard().getScore(true));
        System.out.println("White Score : " + g.getBoard().getScore(false));

    }

}
