package com.saurabh.mychessengine;

import java.util.ArrayList;
import java.util.List;

public class Knight extends Piece {

    public Knight(boolean isBlack) {
        super(isBlack);
        this.value = 3;
        if (isBlack) this.name  = "n";
        else this.name = "N";
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
        if(currentPosition.getColumn() >= 2 && currentPosition.getRow() >= 1) {
            possibleLocation = board.getSquares()[currentPosition.getRow() - 1][currentPosition.getColumn() - 2];
            isCapturingMove(currentPosition,moves,possibleLocation);
        }

        //Check left - down
        if(currentPosition.getColumn() >= 2 && currentPosition.getRow() <= 6) {
            possibleLocation = board.getSquares()[currentPosition.getRow() + 1][currentPosition.getColumn() - 2];
            isCapturingMove(currentPosition,moves,possibleLocation);
        }

        //Check Right - down
        if(currentPosition.getColumn() <= 5 && currentPosition.getRow() <= 6) {
            possibleLocation = board.getSquares()[currentPosition.getRow() + 1][currentPosition.getColumn() + 2];
            isCapturingMove(currentPosition,moves,possibleLocation);
        }

        //Check Right - up
        if(currentPosition.getColumn() <= 5 && currentPosition.getRow() >= 1) {
            possibleLocation = board.getSquares()[currentPosition.getRow() - 1][currentPosition.getColumn() + 2];
            isCapturingMove(currentPosition,moves,possibleLocation);
        }

        //Check Up - Left
        if(currentPosition.getColumn() >= 1 && currentPosition.getRow() >= 2) {
            possibleLocation = board.getSquares()[currentPosition.getRow() - 2][currentPosition.getColumn() - 1];
            isCapturingMove(currentPosition,moves,possibleLocation);
        }

        //Check Up - Right
        if(currentPosition.getColumn() <= 6 && currentPosition.getRow() >= 2) {
            possibleLocation = board.getSquares()[currentPosition.getRow() - 2][currentPosition.getColumn() + 1];
            isCapturingMove(currentPosition,moves,possibleLocation);
        }

        //Check Down - Left
        if(currentPosition.getColumn() >= 1 && currentPosition.getRow() <= 5) {
            possibleLocation = board.getSquares()[currentPosition.getRow() + 2][currentPosition.getColumn() - 1];
            isCapturingMove(currentPosition,moves,possibleLocation);
        }

        //Check Down - Right
        if(currentPosition.getColumn() <= 6 && currentPosition.getRow() <= 5) {
            possibleLocation = board.getSquares()[currentPosition.getRow() + 2][currentPosition.getColumn() + 1];
            isCapturingMove(currentPosition,moves,possibleLocation);
        }

        return moves;
    }
}
