package com.saurabh.mychessengine.pieces;

import com.saurabh.mychessengine.Board;
import com.saurabh.mychessengine.Move;
import com.saurabh.mychessengine.Square;

import java.util.ArrayList;
import java.util.List;

public class King extends Piece {

    public King(boolean isBlack) {
        super(isBlack);
        this.value = 100;
        if (isBlack) this.name  = "k";
        else this.name = "K";
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
        if(currentPosition.getColumn() != 0) {
            possibleLocation = board.getSquares()[currentPosition.getRow()][currentPosition.getColumn() - 1];
            isCapturingMove(currentPosition,moves,possibleLocation);
        }

        //Check Right
        if(currentPosition.getColumn() != 7) {
            possibleLocation = board.getSquares()[currentPosition.getRow()][currentPosition.getColumn() + 1];
            isCapturingMove(currentPosition,moves,possibleLocation);
        }

        //Check Up
        if(currentPosition.getRow() != 0) {
            possibleLocation = board.getSquares()[currentPosition.getRow() - 1][currentPosition.getColumn()];
            isCapturingMove(currentPosition,moves,possibleLocation);
        }

        //Check Down
        if(currentPosition.getRow() != 7) {
            possibleLocation = board.getSquares()[currentPosition.getRow() + 1][currentPosition.getColumn()];
            isCapturingMove(currentPosition,moves,possibleLocation);
        }

        //Check Up-Left
        if(currentPosition.getRow() != 0 && currentPosition.getColumn() != 0) {
            possibleLocation = board.getSquares()[currentPosition.getRow() - 1][currentPosition.getColumn() - 1];
            isCapturingMove(currentPosition,moves,possibleLocation);
        }

        //Check Up-Right
        if(currentPosition.getRow() != 0 && currentPosition.getColumn() != 7) {
            possibleLocation = board.getSquares()[currentPosition.getRow() - 1][currentPosition.getColumn() + 1];
            isCapturingMove(currentPosition,moves,possibleLocation);
        }

        //Check Down-Left
        if(currentPosition.getRow() != 7 && currentPosition.getColumn() != 0) {
            possibleLocation = board.getSquares()[currentPosition.getRow() + 1][currentPosition.getColumn() - 1];
            isCapturingMove(currentPosition,moves,possibleLocation);
        }

        //Check Down-Right
        if(currentPosition.getRow() != 7 && currentPosition.getColumn() != 7) {
            possibleLocation = board.getSquares()[currentPosition.getRow() + 1][currentPosition.getColumn() + 1];
            isCapturingMove(currentPosition,moves,possibleLocation);
        }

        return moves;
    }
}
