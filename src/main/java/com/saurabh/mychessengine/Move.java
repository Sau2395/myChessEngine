package com.saurabh.mychessengine;

import com.saurabh.mychessengine.pieces.Piece;

public class Move {

    private Square start;
    private Square stop;
    private Piece pieceToBeMoved;
    private Piece capturedPiece;
    private int value;

    public int getValue() {
        return value;
    }

    public Move(Square start, Square stop, Piece pieceToBeMoved, Piece capturedPiece) {
        this.start = start;
        this.stop = stop;
        this.pieceToBeMoved = pieceToBeMoved;
        this.capturedPiece = capturedPiece;
        this.value = 0;
        if(this.capturedPiece != null)
            this.value = this.capturedPiece.getValue();
    }

    public Square getStart() {
        return start;
    }
    public Square getStop() {
        return stop;
    }
    public Piece getPieceToBeMoved() {
        return pieceToBeMoved;
    }
    public Piece getCapturedPiece() {
        return capturedPiece;
    }

    @Override
    public String toString() {
        StringBuilder ans = new StringBuilder();
        ans.append("Move : " + start.getPositionValue() +
                "(" + pieceToBeMoved.getName() +
                ") -> " + stop.getPositionValue()
        );

        if(capturedPiece != null) {
            ans.append(" capturing Piece " + capturedPiece.getName() +
                    " Points : " + getValue()
            );
        }
        return ans.toString();
    }
}
