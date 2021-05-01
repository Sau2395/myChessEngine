package com.saurabh.mychessengine;

import java.util.ArrayList;
import java.util.List;

public class King extends Piece {

    public King(boolean isBlack) {
        super(isBlack);
        this.value = 100;
        if (isBlack) this.name  = "BA";
        else this.name = "WA";
    }

    @Override
    public boolean canMove(Board board, Square s1, Square s2) {
        return false;
    }

    @Override
    public List<Move> validMoves(Board board, Square currentPosition) {
        List<Move> moves = new ArrayList<>();
        Square possibleLocation;

        //Check left
        if(currentPosition.getX() != 0) {
            possibleLocation = board.getSquares()[currentPosition.getX() - 1][currentPosition.getY()];
            isCapturingMove(currentPosition,moves,possibleLocation);
        }

        //Check Right
        if(currentPosition.getX() != 7) {
            possibleLocation = board.getSquares()[currentPosition.getX() + 1][currentPosition.getY()];
            isCapturingMove(currentPosition,moves,possibleLocation);
        }

        //Check Up
        if(currentPosition.getY() != 0) {
            possibleLocation = board.getSquares()[currentPosition.getX()][currentPosition.getY() - 1];
            isCapturingMove(currentPosition,moves,possibleLocation);
        }

        //Check Down
        if(currentPosition.getY() != 7) {
            possibleLocation = board.getSquares()[currentPosition.getX()][currentPosition.getY() + 1];
            isCapturingMove(currentPosition,moves,possibleLocation);
        }

        //Check Up-Left
        if(currentPosition.getX() != 0 && currentPosition.getY() != 0) {
            possibleLocation = board.getSquares()[currentPosition.getX() - 1][currentPosition.getY() - 1];
            isCapturingMove(currentPosition,moves,possibleLocation);
        }

        //Check Up-Right
        if(currentPosition.getX() != 7 && currentPosition.getY() != 0) {
            possibleLocation = board.getSquares()[currentPosition.getX() + 1][currentPosition.getY() - 1];
            isCapturingMove(currentPosition,moves,possibleLocation);
        }

        //Check Down-Left
        if(currentPosition.getX() != 0 && currentPosition.getY() != 7) {
            possibleLocation = board.getSquares()[currentPosition.getX() - 1][currentPosition.getY() + 1];
            isCapturingMove(currentPosition,moves,possibleLocation);
        }

        //Check Down-Right
        if(currentPosition.getX() != 7 && currentPosition.getY() != 7) {
            possibleLocation = board.getSquares()[currentPosition.getX() + 1][currentPosition.getY() + 1];
            isCapturingMove(currentPosition,moves,possibleLocation);
        }

        return moves;
    }
}
