package com.timeless.tictactoe;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

class BoardTest {

    @ParameterizedTest
    @CsvSource({
            "0, 0",
            "0, 1",
            "0, 2",
            "1, 0",
            "1, 1",
            "1, 2",
            "2, 0",
            "2, 1",
            "2, 2"
    })
    void shouldCreateAnEmptyBoard(int x, int y) {

        var board = new Board();

        assertThat(board.player(x, y)).isEmpty();
    }

    @ParameterizedTest
    @CsvSource({
            "0, 0, CROSS",
            "0, 1, NOUGHT",
            "0, 2, CROSS",
            "1, 0, NOUGHT",
            "1, 1, CROSS",
            "1, 2, NOUGHT",
            "2, 0, CROSS",
            "2, 1, NOUGHT",
            "2, 2, CROSS"
    })
    void shouldPlacePlayerOnTheBoard(int x, int y, String playerName) {

        var board = new Board();
        board.placePlayer(x, y, Player.valueOf(playerName));

        assertThat(board.player(x, y)).contains(Player.valueOf(playerName));
    }
}