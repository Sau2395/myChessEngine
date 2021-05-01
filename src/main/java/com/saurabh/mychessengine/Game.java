package com.saurabh.mychessengine;

public class Game {

    private Board board;
    private Player[] players;
    private GameStatus status;
    private Player currentTurn;

    private void create(Player p1, Player p2) {
        players[0] = p1;
        players[1] = p2;
        board.reset();
    }

    Game() {
        this.board = new Board();
        board.reset();
    }

    Game(Player p1, Player p2) {
        create(p1, p2);
    }

    public String displayCurrentStatus() {
        return board.display();
    }

    public Board getBoard() {
        return board;
    }

    public GameStatus getStatus() { return this.status; }


}
