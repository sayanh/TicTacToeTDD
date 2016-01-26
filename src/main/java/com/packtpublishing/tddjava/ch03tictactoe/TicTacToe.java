package com.packtpublishing.tddjava.ch03tictactoe;


public class TicTacToe {
    private Character[][] board = { { '\0', '\0', '\0' },
            { '\0', '\0', '\0' },
            { '\0', '\0', '\0' } };

    public void play(int x, int y) {
        checkXAxis(x);

        checkYAxis(y);

        setBox(x, y);

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

    public void setBox(int x, int y) {
        if ( board[x - 1][y - 1] != '\0' ) {
            throw new RuntimeException("Box is occupied");
        } else {
            board[x - 1][y - 1] = 'X';
        }
    }
}