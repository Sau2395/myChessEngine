package com.saurabh.mychessengine;

import java.util.ArrayList;
import java.util.List;

public class Knight extends Piece {

    public Knight(boolean isBlack) {
        super(isBlack);
        this.value = 3;
        if (isBlack) this.name  = "BK";
        else this.name = "WK";
    }

    @Override
    public boolean canMove(Board board, Square s1, Square s2) {
        return false;
    }

    @Override
    public List<Move> validMoves(Board board, Square currentPosition) {
        List<Move> moves = new ArrayList<>();
        Square possibleLocation;

        //Check left - up
        if(currentPosition.getY() >= 2 && currentPosition.getX() >= 1) {
            possibleLocation = board.getSquares()[currentPosition.getX() - 1][currentPosition.getY() - 2];
            isCapturingMove(currentPosition,moves,possibleLocation);
        }

        //Check left - down
        if(currentPosition.getY() >= 2 && currentPosition.getX() <= 6) {
            possibleLocation = board.getSquares()[currentPosition.getX() + 1][currentPosition.getY() - 2];
            isCapturingMove(currentPosition,moves,possibleLocation);
        }

        //Check Right - down
        if(currentPosition.getY() <= 5 && currentPosition.getX() <= 6) {
            possibleLocation = board.getSquares()[currentPosition.getX() + 1][currentPosition.getY() + 2];
            isCapturingMove(currentPosition,moves,possibleLocation);
        }

        //Check Right - up
        if(currentPosition.getY() <= 5 && currentPosition.getX() >= 1) {
            possibleLocation = board.getSquares()[currentPosition.getX() - 1][currentPosition.getY() + 2];
            isCapturingMove(currentPosition,moves,possibleLocation);
        }

        //Check Up - Left
        if(currentPosition.getY() >= 1 && currentPosition.getX() >= 2) {
            possibleLocation = board.getSquares()[currentPosition.getX() - 2][currentPosition.getY() - 1];
            isCapturingMove(currentPosition,moves,possibleLocation);
        }

        //Check Up - Right
        if(currentPosition.getY() <= 6 && currentPosition.getX() >= 2) {
            possibleLocation = board.getSquares()[currentPosition.getX() - 2][currentPosition.getY() + 1];
            isCapturingMove(currentPosition,moves,possibleLocation);
        }

        //Check Down - Left
        if(currentPosition.getY() >= 1 && currentPosition.getX() <= 5) {
            possibleLocation = board.getSquares()[currentPosition.getX() + 2][currentPosition.getY() - 1];
            isCapturingMove(currentPosition,moves,possibleLocation);
        }

        //Check Down - Right
        if(currentPosition.getY() <= 6 && currentPosition.getX() <= 5) {
            possibleLocation = board.getSquares()[currentPosition.getX() + 2][currentPosition.getY() + 1];
            isCapturingMove(currentPosition,moves,possibleLocation);
        }

        return moves;
    }
}
