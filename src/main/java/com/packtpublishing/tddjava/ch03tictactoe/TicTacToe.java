package com.packtpublishing.tddjava.ch03tictactoe;


public class TicTacToe {

    private char lastPlayer = '\0';
    private Character[][] board = { { '\0', '\0', '\0' },
            { '\0', '\0', '\0' },
            { '\0', '\0', '\0' } };

    public String play(int x, int y) {
        checkXAxis(x);

        checkYAxis(y);

        lastPlayer = nextPlayer();

        setBox(x, y, lastPlayer);

        for ( int index = 0; index < 3; index++ ) {
            if ( isWin() ) {
                return lastPlayer + " is the winner";
            }
        }
        return "No winner";

    }

    private boolean isWin() {
        for ( int index = 0; index < 3; index++ ) {
            if ( board[0][index] == lastPlayer && board[1][index] == lastPlayer && board[2][index] == lastPlayer ) {
                return true;
            }
        }

        for ( int index = 0; index < 3; index++ ) {
            if ( board[index][0] == lastPlayer && board[index][1] == lastPlayer && board[index][2] == lastPlayer ) {
                return true;
            }
        }

        // Left diagonal
        if ( board[0][0] == lastPlayer && board[1][1] == lastPlayer && board[2][2] == lastPlayer ) {
            return true;
        }

        // Right diagonal
        if ( board[2][0] == lastPlayer && board[1][1] == lastPlayer && board[0][2] == lastPlayer ) {
            return true;
        }

        return false;
    }

    public void checkXAxis(int x) {
        if ( x < 1 || x > 3 ) {
            throw new RuntimeException("X is outside the grid");
        }
    }

    public void checkYAxis(int y) {
        if ( y < 1 || y > 3 ) {
            throw new RuntimeException("Y is outside the grid");
        }
    }

    public void setBox(int x, int y, char lastPlayer) {
        if ( board[x - 1][y - 1] != '\0' ) {
            throw new RuntimeException("Box is occupied");
        } else {
            board[x - 1][y - 1] = lastPlayer;
        }
    }

    public char nextPlayer() {
        if ( lastPlayer == 'X' ) {
            return 'O';
        }
        return 'X';
    }
}