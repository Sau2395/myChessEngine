package com.saurabh.mychessengine;

import org.apache.tomcat.util.http.fileupload.impl.InvalidContentTypeException;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Game {

    final List<Move> history;
    private Board board;
    private Player[] players;
    private GameStatus status;
    private Player currentTurn;
    private int playedMoves;
    private int halfMoves;
    private boolean castlingAvailable;
    private String en_passant;

    public int getHalfMoves() {
        return halfMoves;
    }

    public void setHalfMoves(int halfMoves) {
        this.halfMoves = halfMoves;
    }

    Game(Player p1, Player p2) {
        this.players = new Player[] {p1, p2};
        this.board = new Board();
        this.board.reset();
        this.playedMoves = 0;
        this.halfMoves = 0;
        this.status = GameStatus.ACTIVE;
        this.history = new ArrayList<>();
    }

    public void addMoveToHistory(Move move) {
        this.history.add(move);
    }

    public void removeLastMoveFromHistory() {
        this.history.remove(this.history.size() - 1);
    }

    public String displayCurrentStatus() {
        return board.display();
    }

    public Board getBoard() {
        return board;
    }

    public GameStatus getStatus() { return this.status; }

    public void setStatus(GameStatus status) {
        this.status = status;
    }

    public Player getCurrentTurn() {
        return currentTurn;
    }

    public void setCurrentTurn(Player currentTurn) {
        this.currentTurn = currentTurn;
    }

    public int getPlayedMoves() {
        return playedMoves;
    }

    public boolean isCastlingAvailable() {
        return castlingAvailable;
    }

    public void setCastlingAvailable(boolean castlingAvailable) {
        this.castlingAvailable = castlingAvailable;
    }

    public String getEn_passant() {
        return en_passant;
    }

    public void setEn_passant(String en_passant) {
        this.en_passant = en_passant;
    }

    public void setPlayedMoves(int playedMoves) {
        this.playedMoves = playedMoves;
    }

    public void setGame(String fen) {

        //Splitting sections of the FEN string.
        String[] sections = fen.split(" ");

        //Setting board.
        this.board.setBoard(sections[0]);

        //Setting player turn.
        this.currentTurn = Arrays.stream(this.players)
                .filter(player -> player.getColor().equals(sections[1]))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("No player found with color : " + sections[1]));

        //TODO : Getting Castling Status. sections[2]
        setCastlingAvailable(!sections[2].contains("-"));

        //TODO : Setting en-passant value. sections[3]
        setEn_passant(sections[3]);

        //Setting Half Moves.
        setHalfMoves(Integer.parseInt(sections[4]));

        //Setting Played Moves.
        setPlayedMoves(Integer.parseInt(sections[5]));
    }
}
