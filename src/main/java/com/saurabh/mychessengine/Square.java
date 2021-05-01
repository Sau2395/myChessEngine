package com.saurabh.mychessengine;

public class Square {

    private int x;
    private int y;
    private Piece piece;

    Square(int x, int y, Piece piece) {
        this.x = x;
        this.y = y;
        this.piece = piece;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public Piece getPiece() {
        return piece;
    }

    public String display() {
        if (piece != null) {
            return piece.name;
        }
        else {
            return "--";
        }
    }

    public boolean isOccupied() {
        return piece != null;
    }
    public void setPiece(Piece piece) {
        this.piece = piece;
    }
}
