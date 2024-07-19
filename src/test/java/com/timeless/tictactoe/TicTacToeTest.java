package com.timeless.tictactoe;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class TicTacToeTest {

    @Test
    void shouldIndicateNoPlayerHasWonIfBoardIsEmpty() {

        Board board = new Board();

        assertThat(TicTacToe.winningPlayer(board)).isEmpty();
    }
}