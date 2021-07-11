package com.saurabh.mychessengine.pieces;

import com.saurabh.mychessengine.Board;
import com.saurabh.mychessengine.Move;
import com.saurabh.mychessengine.Square;

import java.util.List;

public abstract class Piece {

    protected int value;
    private boolean black;
    private boolean isKilled;
    private boolean unMoved;
    protected String name;

    public Piece(boolean isBlack) {
        this.black = isBlack;
        this.isKilled = false;
        this.unMoved = true;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isUnMoved() {
        return unMoved;
    }

    public void moved() {
        this.unMoved = false;
    }

    public int getValue() {
        return value;
    }

    public boolean isBlack() {
        return black;
    }

    public void setBlack(boolean black) {
        this.black = black;
    }

    public boolean isKilled() {
        return isKilled;
    }

    public void setKilled(boolean killed) {
        isKilled = killed;
    }

    public abstract boolean canMove(Board board, Square s1, Square s2);

    public abstract List<Move> validMoves(Board board, Square currentPosition);

    protected boolean isCapturingMove(Square currentPosition, List<Move> moves, Square possibleLocation) {
        //System.out.println("Considering: X :" + possibleLocation.getRow() + "\tY: " + possibleLocation.getColumn());
        if(possibleLocation.isOccupied()) {
            //System.out.println("Occupied : " + possibleLocation.getPiece().name);
            if(possibleLocation.getPiece().isBlack() != isBlack()) {
                //System.out.println("Added: " + possibleLocation.getRow() + "\tY:" + possibleLocation.getColumn());
                moves.add(new Move(currentPosition, possibleLocation, currentPosition.getPiece(), possibleLocation.getPiece()));
            }
            return true;
        }
        else {
            //System.out.println("Added: " + possibleLocation.getRow() + "\tY:" + possibleLocation.getColumn());
            moves.add(new Move(currentPosition, possibleLocation, currentPosition.getPiece(), null));
        }
        return false;
    }

    private boolean getValidRowMoves(Board board, Square currentPosition, List<Move> moves, int x) {
        Square possibleLocation;
        possibleLocation = board.getSquares()[x][currentPosition.getColumn()];
        return isCapturingMove(currentPosition, moves, possibleLocation);
    }

    private boolean getValidColumnMoves(Board board, Square currentPosition, List<Move> moves, int y) {
        Square possibleLocation;
        possibleLocation = board.getSquares()[currentPosition.getRow()][y];
        return isCapturingMove(currentPosition, moves, possibleLocation);
    }

    private boolean getValidXYMoves(Board board, Square currentPosition, List<Move> moves, int x, int y) {
        Square possibleLocation;
        possibleLocation = board.getSquares()[x][y];
        return isCapturingMove(currentPosition, moves, possibleLocation);
    }

    protected void getValidLeftRightMoves(Board board, Square currentPosition, List<Move> moves) {
        //Checking left.
        for(int i = currentPosition.getColumn() - 1; i >= 0; i--) {
            if (getValidColumnMoves(board, currentPosition, moves, i)) break;
        }

        //Checking right.
        for(int i = currentPosition.getColumn() + 1; i < board.getColumn(); i++) {
            if (getValidColumnMoves(board, currentPosition, moves, i)) break;
        }
    }

    protected void getValidUpDownMoves(Board board, Square currentPosition, List<Move> moves) {
        //Checking up.
        for(int i = currentPosition.getRow() - 1; i >= 0; i--) {
            if (getValidRowMoves(board, currentPosition, moves, i)) break;
        }

        //Checking down.
        for(int i = currentPosition.getRow() + 1; i < board.getRow(); i++) {
            if (getValidRowMoves(board, currentPosition, moves, i)) break;
        }
    }

    protected void getValidAcrossMoves(Board board, Square currentPosition, List<Move> moves) {
        //Checking up-left.
        for(int i = currentPosition.getRow() - 1, j = currentPosition.getColumn() - 1;
            i >= 0 && j >= 0;
            j--, i--) {
            if (getValidXYMoves(board, currentPosition, moves, i, j)) break;
        }

        //Checking up-right.
        for(int i = currentPosition.getRow() - 1, j = currentPosition.getColumn() + 1;
            i >= 0 && j < board.getColumn();
            j++, i--) {
            if (getValidXYMoves(board, currentPosition, moves, i, j)) break;
        }

        //Checking down-left.
        for(int i = currentPosition.getRow() + 1, j = currentPosition.getColumn() - 1;
            i < board.getRow() && j >= 0;
            j--, i++) {
            if (getValidXYMoves(board, currentPosition, moves, i, j)) break;
        }

        //Checking up-left.
        for(int i = currentPosition.getRow() + 1, j = currentPosition.getColumn() + 1;
            i < board.getRow() && j < board.getColumn();
            j++, i++) {
            if (getValidXYMoves(board, currentPosition, moves, i, j)) break;
        }
    }
}
