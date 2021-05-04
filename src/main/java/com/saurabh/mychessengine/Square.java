package com.saurabh.mychessengine;

public class Square {

    private final int row;
    private final int column;
    private Piece piece;

    Square(int row, int column, Piece piece) {
        this.row = row;
        this.column = column;
        this.piece = piece;
    }

    public int getRow() {
        return row;
    }

    public int getColumn() {
        return column;
    }

    public Piece getPiece() {
        return piece;
    }

    public String display() {
        if (piece != null) {
            return piece.name;
        }
        else {
            return "-";
        }
    }

    public boolean isOccupied() {
        return piece != null;
    }
    public void setPiece(Piece piece) {
        this.piece = piece;
    }
}
