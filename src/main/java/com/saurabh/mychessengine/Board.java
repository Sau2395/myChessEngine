package com.saurabh.mychessengine;

import com.saurabh.mychessengine.pieces.*;

public class Board {
    private Square[][] squares;
    private int row;
    private int column;
    private int totalScore = 139;

    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public int getColumn() {
        return column;
    }

    public void setColumn(int column) {
        this.column = column;
    }

    Board() {
        this.row = 8;
        this.column = 8;
        squares = new Square[row][column];
    }

    private void setInitialRKBQ(int i, boolean isBlack) {
        squares[i][0] = new Square(i, 0 , new Rook(isBlack));
        squares[i][1] = new Square(i, 1 , new Knight(isBlack));
        squares[i][2] = new Square(i, 2 , new Bishop(isBlack));
        squares[i][3] = new Square(i, 3 , new Queen(isBlack));
        squares[i][5] = new Square(i, 7 , new Rook(isBlack));
        squares[i][6] = new Square(i, 6 , new Knight(isBlack));
        squares[i][7] = new Square(i, 5 , new Bishop(isBlack));
    }

    private void setInitialPawns(int i, boolean isBlack) {
        for(int j = 0; j < 8; j++) {
            squares[i][j] = new Square(i, j , new Pawn(isBlack));
        }
    }

    public Square[][] getSquares() {
        return squares;
    }

    public void setBoard(String fen) {
        int i = 0;
        for (String s:fen.split("/")) {
            int j = 0;
            //System.out.println("S: " + s);
            for (char c:s.toCharArray()) {
                if(Character.isDigit(c)) {
                    for(int k = 0; k < Character.getNumericValue(c); k++,j++) {
                        //System.out.println("i : " + i + "\t j : "+j +"\t k :"+k);
                        squares[i][j] = new Square(i, j, null);
                    }
                }
                else {
                    switch(c) {
                        case 'p' :
                            squares[i][j] = new Square(i, j++ , new Pawn(true));
                            if(i >= 2) { squares[i][j-1].getPiece().moved(); }
                            break;
                        case 'P' :
                            squares[i][j] = new Square(i, j++ , new Pawn(false));
                            if(i <= 5) { squares[i][j-1].getPiece().moved(); }
                            break;
                        case 'r' :
                            squares[i][j] = new Square(i, j++ , new Rook(true)); break;
                        case 'R' :
                            squares[i][j] = new Square(i, j++ , new Rook(false)); break;
                        case 'n' :
                            squares[i][j] = new Square(i, j++ , new Knight(true)); break;
                        case 'N' :
                            squares[i][j] = new Square(i, j++ , new Knight(false)); break;
                        case 'b' :
                            squares[i][j] = new Square(i, j++ , new Bishop(true)); break;
                        case 'B' :
                            squares[i][j] = new Square(i, j++ , new Bishop(false)); break;
                        case 'q' :
                            squares[i][j] = new Square(i, j++ , new Queen(true)); break;
                        case 'Q' :
                            squares[i][j] = new Square(i, j++ , new Queen(false)); break;
                        case 'k' :
                            squares[i][j] = new Square(i, j++ , new King(true)); break;
                        case 'K' :
                            squares[i][j] = new Square(i, j++ , new King(false)); break;
                        default:
                            throw new IllegalArgumentException("Unable to find chess piece with notation : " + c);
                    }
                }
            }
            i++;
        }
    }

    public void reset() {

        //Adding white pieces
        setInitialRKBQ(0,false);
        setInitialPawns(1,false);
        squares[0][4] = new Square(0, 4 , new King(false));

        //Adding Empty Spaces
        for(int i = 2; i < row; i++) {
            for(int j = 0; j < column; j++) {
                squares[i][j] = new Square(0, 4 , null);
            }
        }

        //Adding Black pieces
        setInitialRKBQ(7,true);
        setInitialPawns(6,true);
        squares[7][4] = new Square(7, 4 , new King(true));

    }

    public String display() {
        StringBuilder board = new StringBuilder();

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                System.out.print(squares[i][j].display() + "\t");
                board.append(squares[i][j].display()).append("\t");
            }
            System.out.println();
            board.append("\n");
        }

        return board.toString();
    }

    public long getValidMovesCount(boolean isBlack) {
        long count = 0;

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                if(squares[i][j].isOccupied()) {
                    Piece piece = squares[i][j].getPiece();
                    if(piece.isBlack() == isBlack) {
                        long x = piece.validMoves(this, squares[i][j]).size();
                        count += x;
                        //System.out.println("Piece : " + piece.getName() + " \t Moves: " + x);
                    }
                }
            }
        }

        return count;
    }

    public int getScore(boolean isBlack) {
        int score = 0;

        for(int i = 0; i < row; i++) {
            for(int j = 0; j < column; j++) {
                if(squares[i][j].isOccupied()) {
                    Piece piece = squares[i][j].getPiece();
                    if(piece.isBlack() != isBlack) {
                        score += piece.getValue();
                    }
                }
            }
        }

        return totalScore - score;
    }
}
