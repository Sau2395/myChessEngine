package com.saurabh.mychessengine.pieces;

import com.saurabh.mychessengine.Board;
import com.saurabh.mychessengine.Move;
import com.saurabh.mychessengine.Square;

import java.util.ArrayList;
import java.util.List;

public class Pawn extends Piece {

    public Pawn(boolean isBlack) {
        super(isBlack);
        this.value = 1;
        if (isBlack) this.name  = "p";
        else this.name = "P";
    }

    @Override
    public boolean canMove(Board board, Square s1, Square s2) {
        return false;
    }

    @Override
    public List<Move> validMoves(Board board, Square currentPosition) {
        List<Move> moves = new ArrayList<>();
        Square possibleLocation;
        int direction = -1;
        if(isBlack()) {
            direction = 1;
        }

        // If unmoved, find valid 2 steps move.
        if(this.isUnMoved()) {
            //System.out.println("N: " + name + "\tX: " + currentPosition.getX() + "\tY: " + currentPosition.getY() + "\t D: " + direction);
            possibleLocation = board.getSquares()[currentPosition.getRow() + (direction * 2)][currentPosition.getColumn()];
            if(!possibleLocation.isOccupied() && !board.getSquares()[currentPosition.getRow() + direction][currentPosition.getColumn()].isOccupied()) {
                moves.add(new Move(currentPosition, possibleLocation, this, null));
            }
        }

        //find valid one step move.
        possibleLocation = board.getSquares()[currentPosition.getRow() + (direction)][currentPosition.getColumn()];
        if(!possibleLocation.isOccupied()) {
            moves.add(new Move(currentPosition, possibleLocation, this, null));
        }

        //find capturing move 1.
        if(currentPosition.getColumn() != 0) {
            possibleLocation = board.getSquares()[currentPosition.getRow() + (direction)][currentPosition.getColumn()-1];
            if(possibleLocation.isOccupied()) {
                if(possibleLocation.getPiece().isBlack() != isBlack())
                    moves.add(new Move(currentPosition, possibleLocation, this, possibleLocation.getPiece()));
            }
        }

        //find capturing move 2.
        if(currentPosition.getColumn() != 7) {
            possibleLocation = board.getSquares()[currentPosition.getRow() + (direction)][currentPosition.getColumn() + 1];
            if(possibleLocation.isOccupied()) {
                if(possibleLocation.getPiece().isBlack() != isBlack())
                    moves.add(new Move(currentPosition, possibleLocation, this, possibleLocation.getPiece()));
            }
        }

        return moves;
    }
}
