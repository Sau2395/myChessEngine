package com.saurabh.mychessengine;

import java.util.List;

public abstract class Piece {

    protected int value;
    private boolean isBlack;
    private boolean isKilled;
    private boolean unMoved;
    protected String name;

    public Piece(boolean isBlack) {
        this.isBlack = isBlack;
        this.isKilled = false;
        this.unMoved = true;
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
        return isBlack;
    }

    public void setBlack(boolean black) {
        isBlack = black;
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
        if(possibleLocation.isOccupied()) {
            if(possibleLocation.getPiece().isBlack() != isBlack()) {
                System.out.println("Added: " + currentPosition.getPiece().name + "\tCap: " + possibleLocation.getPiece().name);
                moves.add(new Move(currentPosition, possibleLocation, this, possibleLocation.getPiece()));
            }
            return true;
        }
        else {
            System.out.println("Added: " + currentPosition.getX() + "\tY:" + currentPosition.getY());
            moves.add(new Move(currentPosition, possibleLocation, this, null));
        }
        return false;
    }

    private boolean getValidXMoves(Board board, Square currentPosition, List<Move> moves, int x) {
        Square possibleLocation;
        possibleLocation = board.getSquares()[x][currentPosition.getY()];
        return isCapturingMove(currentPosition, moves, possibleLocation);
    }

    private boolean getValidYMoves(Board board, Square currentPosition, List<Move> moves, int y) {
        Square possibleLocation;
        possibleLocation = board.getSquares()[currentPosition.getX()][y];
        return isCapturingMove(currentPosition, moves, possibleLocation);
    }

    private boolean getValidXYMoves(Board board, Square currentPosition, List<Move> moves, int x, int y) {
        Square possibleLocation;
        possibleLocation = board.getSquares()[x][y];
        return isCapturingMove(currentPosition, moves, possibleLocation);
    }

    protected void getValidLeftRightMoves(Board board, Square currentPosition, List<Move> moves) {
        //Checking left.
        for(int i = currentPosition.getX(); i >= 0; i--) {
            if (getValidXMoves(board, currentPosition, moves, i)) break;
        }

        //Checking right.
        for(int i = currentPosition.getX(); i < 8; i++) {
            if (getValidXMoves(board, currentPosition, moves, i)) break;
        }
    }

    protected void getValidUpDownMoves(Board board, Square currentPosition, List<Move> moves) {
        //Checking up.
        for(int i = currentPosition.getY(); i >= 0; i--) {
            if (getValidYMoves(board, currentPosition, moves, i)) break;
        }

        //Checking down.
        for(int i = currentPosition.getY(); i < 8; i++) {
            if (getValidYMoves(board, currentPosition, moves, i)) break;
        }
    }

    protected void getValidAcrossMoves(Board board, Square currentPosition, List<Move> moves) {
        //Checking up-left.
        outer:
        for(int i = currentPosition.getX(); i >= 0; i--) {
            for(int j = currentPosition.getY(); j >= 0; j--) {
                if (getValidXYMoves(board, currentPosition, moves, i, j)) {
                    break outer;
                }
            }
        }

        //Checking up-right.
        outer:
        for(int i = currentPosition.getX(); i >= 0; i--) {
            for(int j = currentPosition.getY(); j < 8; j++) {
                if (getValidXYMoves(board, currentPosition, moves, i, j)) break outer;
            }
        }

        //Checking down-left.
        outer:
        for(int i = currentPosition.getX(); i < 8; i++) {
            for(int j = currentPosition.getY(); j >= 0; j--) {
                if (getValidXYMoves(board, currentPosition, moves, i, j)) break outer;
            }
        }

        //Checking up-left.
        outer:
        for(int i = currentPosition.getX(); i < 8; i++) {
            for(int j = currentPosition.getY(); j < 8; j++) {
                if (getValidXYMoves(board, currentPosition, moves, i, j)) break outer;
            }
        }
    }
}
