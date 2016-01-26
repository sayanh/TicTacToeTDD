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

        if ( isWin(x, y) ) {
            return lastPlayer + " is the winner";
        } else if ( isDraw() ) {
            return "The result is draw";
        }
        return "No winner";

    }

    private boolean isWin(int x, int y) {

        char vertical, horizontal, diagonal1, diagonal2;
        vertical = horizontal = diagonal1 = diagonal2 = '\0';
        int playerTotal = 3 * lastPlayer;
        for ( int i = 0; i < 3; i++ ) {
            vertical += board[x - 1][i];
            horizontal += board[i][y - 1];
            diagonal1 += board[i][i];
            diagonal2 += board[3 - i - 1][i];
        }

        if ( vertical == playerTotal || horizontal == playerTotal || diagonal1 == playerTotal || diagonal2 == playerTotal ) {
            return true;
        }

        return false;
    }

    private boolean isDraw() {
        for ( int i = 0; i < board.length; i++ ) {
            for ( int j = 0; j < board.length; j++ ) {
                if ( board[i][j] == '\0' ) {
                    return false;
                }
            }
        }

        return true;
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