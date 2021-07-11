package com.saurabh.mychessengine.pieces;

import com.saurabh.mychessengine.Board;
import com.saurabh.mychessengine.Move;
import com.saurabh.mychessengine.Square;

import java.util.ArrayList;
import java.util.List;

public class Queen extends Piece {

    public Queen(boolean isBlack) {
        super(isBlack);
        this.value = 9;
        if (isBlack) this.name  = "q";
        else this.name = "Q";
    }

    @Override
    public boolean canMove(Board board, Square s1, Square s2) {
        return false;
    }

    @Override
    public List<Move> validMoves(Board board, Square currentPosition) {
        List<Move> moves = new ArrayList<>();
        getValidAcrossMoves(board, currentPosition, moves);
        getValidLeftRightMoves(board, currentPosition, moves);
        getValidUpDownMoves(board, currentPosition, moves);
        return moves;
    }
}
