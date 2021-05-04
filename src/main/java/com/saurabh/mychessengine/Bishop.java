package com.saurabh.mychessengine;

import java.util.ArrayList;
import java.util.List;

public class Bishop extends Piece {

    public Bishop(boolean isBlack) {
        super(isBlack);
        this.value = 3;
        if (isBlack) this.name  = "b";
        else this.name = "B";
    }

    @Override
    public boolean canMove(Board board, Square s1, Square s2) {
        return false;
    }

    @Override
    public List<Move> validMoves(Board board, Square currentPosition) {
        List<Move> moves = new ArrayList<>();
        getValidAcrossMoves(board, currentPosition, moves);
        return moves;
    }
}
