package com.timeless.tictactoe;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

class TicTacToeTest {

    @ParameterizedTest
    @MethodSource("provideBoards")
    void testWinner(List<Character> board, char expectedWinner) {
        assertEquals(expectedWinner, TicTacToe.winner(board));
    }

    private static Stream<Arguments> provideBoards() {
        return Stream.of(
                // Empty board
                Arguments.of(List.of(
                        '-', '-', '-',
                        '-', '-', '-',
                        '-', '-', '-'
                ), '-'),

                // Horizontal win for X
                Arguments.of(List.of(
                        'X', 'X', 'X',
                        'O', 'O', '-',
                        '-', '-', '-'
                ), 'X'),

                // Vertical win for O
                Arguments.of(List.of(
                        'X', 'O', 'X',
                        'X', 'O', '-',
                        '-', 'O', 'X'
                ), 'O'),

                // Diagonal win for X
                Arguments.of(List.of(
                        'X', 'O', 'O',
                        '-', 'X', '-',
                        'O', '-', 'X'
                ), 'X'),

                // No winner
                Arguments.of(List.of(
                        'X', 'O', 'X',
                        'X', 'O', 'O',
                        'O', 'X', 'X'
                ), '-')
        );
    }

    @Test
    void testInvalidBoardSize() {
        List<Character> invalidBoard = List.of('X', 'O', 'X', 'O');
        assertThrows(IllegalArgumentException.class, () -> TicTacToe.winner(invalidBoard));
    }

    @Test
    void testInvalidCharacter() {
        List<Character> invalidBoard = List.of(
                'X', 'O', 'X',
                'O', 'A', '-',
                '-', '-', '-'
        );
        assertThrows(IllegalArgumentException.class, () -> TicTacToe.winner(invalidBoard));
    }

    @Test
    void testLessThanFiveMoves() {
        List<Character> board = List.of(
                'X', 'O', '-',
                'X', '-', '-',
                '-', '-', '-'
        );
        assertEquals('-', TicTacToe.winner(board));
    }

    @Test
    void testValidBoardCounts() {
        // Valid boards
        assertDoesNotThrow(() -> TicTacToe.winner(List.of(
                'X', 'O', 'X',
                'O', 'X', '-',
                '-', '-', '-'
        )));
        assertDoesNotThrow(() -> TicTacToe.winner(List.of(
                'X', 'O', 'X',
                'O', '-', '-',
                '-', '-', '-'
        )));
        assertDoesNotThrow(() -> TicTacToe.winner(List.of(
                'O', 'X', 'O',
                'X', 'O', '-',
                '-', '-', '-'
        )));
    }

    @Test
    void testInvalidBoardCounts() {
        // Invalid boards
        assertThrows(IllegalArgumentException.class, () ->
                TicTacToe.winner(List.of(
                        'X', 'X', 'X',
                        'O', '-', '-',
                        '-', '-', '-'
                )));
        assertThrows(IllegalArgumentException.class, () ->
                TicTacToe.winner(List.of(
                        'O', 'O', 'O',
                        'X', '-', '-',
                        '-', '-', '-'
                )));
    }

    @Test
    void testMultipleWinners() {
        List<Character> invalidBoard = List.of(
                'X', 'X', 'X',
                'O', 'O', 'O',
                '-', '-', '-'
        );
        assertThrows(IllegalArgumentException.class, () -> TicTacToe.winner(invalidBoard));
    }
}
