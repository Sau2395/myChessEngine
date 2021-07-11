package com.saurabh.mychessengine;

import com.saurabh.mychessengine.pieces.Piece;

public class Move {

    private Square start;
    private Square stop;
    private Piece pieceToBeMoved;
    private Piece capturedPiece;

    public Move(Square start, Square stop, Piece pieceToBeMoved, Piece capturedPiece) {
        this.start = start;
        this.stop = stop;
        this.pieceToBeMoved = pieceToBeMoved;
        this.capturedPiece = capturedPiece;
    }

    public Square getStart() {
        return start;
    }

    public void setStart(Square start) {
        this.start = start;
    }

    public Square getStop() {
        return stop;
    }

    public void setStop(Square stop) {
        this.stop = stop;
    }

    public Piece getPieceToBeMoved() {
        return pieceToBeMoved;
    }

    public void setPieceToBeMoved(Piece pieceToBeMoved) {
        this.pieceToBeMoved = pieceToBeMoved;
    }

    public Piece getCapturedPiece() {
        return capturedPiece;
    }

    public void setCapturedPiece(Piece capturedPiece) {
        this.capturedPiece = capturedPiece;
    }
}
