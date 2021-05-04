package com.saurabh.mychessengine;

import java.util.ArrayList;
import java.util.List;

public class Rook extends Piece {

    public Rook(boolean isBlack) {
        super(isBlack);
        this.value = 5;
        if (isBlack) this.name  = "r";
        else this.name = "R";
    }

    @Override
    public boolean canMove(Board board, Square s1, Square s2) {
        return false;
    }

    @Override
    public List<Move> validMoves(Board board, Square currentPosition) {
        List<Move> moves = new ArrayList<>();
        getValidUpDownMoves(board, currentPosition, moves);
        getValidLeftRightMoves(board, currentPosition, moves);
        return moves;
    }
}
