package com.timeless.tictactoe;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class TicTacToeTest {

    @Test
    void shouldIndicateNoPlayerHasWonIfBoardIsEmpty() {

        var board = new Board();

        assertThat(TicTacToe.winningPlayer(board)).isEmpty();
    }

    @Test @Disabled
    void shouldIndicatePlayerHasWonIfThreeInARow() {

        var board = new Board();
        board.placePlayer(0, 0, Player.CROSS);
        board.placePlayer(0, 1, Player.CROSS);
        board.placePlayer(0, 2, Player.CROSS);

        assertThat(TicTacToe.winningPlayer(board)).contains(Player.CROSS);
    }

    @Test @Disabled
    void shouldIndicatePlayerHasWonIfThreeInAColumn() {

        var board = new Board();
        board.placePlayer(0, 0, Player.CROSS);
        board.placePlayer(1, 0, Player.CROSS);
        board.placePlayer(2, 0, Player.CROSS);

        assertThat(TicTacToe.winningPlayer(board)).contains(Player.CROSS);
    }
}