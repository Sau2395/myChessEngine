package com.saurabh.mychessengine;

public class Player {

    private String color;
    public boolean isBlack;

    Player(boolean isBlack) {
        this.isBlack = isBlack;
    }

    public String getColor() {
        return isBlack ? "b":"w";
    }

    public Move play(Board board) {
        Move move = board.getNextMove(isBlack);
        board.makeMove(move);
        return move;
    }


}
