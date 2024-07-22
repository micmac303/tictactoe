package com.timeless.tictactoe;

import java.util.Optional;

public class Board {

    private final Optional<Player>[][] board;

    @SuppressWarnings("unchecked")
    public Board() {
        board = new Optional[3][3];
        for (int x = 0; x < 3; x++) {
            for (int y = 0; y < 3; y++) {
                board[x][y] = Optional.empty();
            }
        }
    }

    public Optional<Player> player(int x, int y) {

        return board[x][y];
    }

    public void placePlayer(int x, int y, Player player) {

        board[x][y] = Optional.of(player);
    }

    public Optional<Player> winningPlayer() {

        return Optional.empty();
    }
}
