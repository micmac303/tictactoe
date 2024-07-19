package com.timeless.tictactoe;

import java.util.Optional;

public class Board {

    private Optional<Player>[][] board;

    @SuppressWarnings("unchecked")
    public Board() {
        board = new Optional[3][3];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                board[i][j] = Optional.empty();
            }
        }
    }
}
