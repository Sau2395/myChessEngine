package com.saurabh.mychessengine;

public class Board {
    private Square[][] squares;

    Board() {
        squares = new Square[8][8];
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

    public void reset() {

        //Adding white pieces
        setInitialRKBQ(0,false);
        setInitialPawns(1,false);
        squares[0][4] = new Square(0, 4 , new King(false));

        //Adding Empty Spaces
        for(int i = 2; i < 8; i++) {
            for(int j = 0; j < 8; j++) {
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

        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                System.out.print(squares[i][j].display() + "\t");
                board.append(squares[i][j].display()).append("\t");
            }
            System.out.println();
            board.append("\n");
        }

        return board.toString();
    }

    public long getValidMovesCount() {
        long count = 0;

        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if(squares[i][j].isOccupied()) {
                    long x = squares[i][j].getPiece().validMoves(this,squares[i][j]).size();
                    count += x;
                    System.out.println("Piece : " + squares[i][j].getPiece().name + " \t Moves: " + x);
                }
            }
        }

        return count;
    }
}
