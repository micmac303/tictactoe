package com.timeless.tictactoe;

import java.util.List;

public class TicTacToe {

    private static final List<List<Integer>> WIN_COMBINATIONS = List.of(
            List.of(0, 1, 2), List.of(3, 4, 5), List.of(6, 7, 8), // Rows
            List.of(0, 3, 6), List.of(1, 4, 7), List.of(2, 5, 8), // Columns
            List.of(0, 4, 8), List.of(2, 4, 6)                    // Diagonals
    );

    public static char winner(List<Character> board) {
        if (board.size() != 9 || board.stream().anyMatch(c -> c != 'X' && c != 'O' && c != '-')) {
            throw new IllegalArgumentException("Invalid board");
        }

        long crossCount = board.stream().filter(c -> c == 'X').count();
        long noughtCount = board.stream().filter(c -> c == 'O').count();

        // Check if the board is valid based on the number of Xs and Os
        long difference = Math.abs(crossCount - noughtCount);
        if (difference > 1) {
            throw new IllegalArgumentException("Invalid board: too many Xs or Os");
        }

        // Check if the number of Xs and Os is less than 5
        if (crossCount + noughtCount < 5) {
            return '-';
        }

        boolean xWins = hasWinner(board, 'X');
        boolean oWins = hasWinner(board, 'O');

        // Check for multiple winners
        if (xWins && oWins) {
            throw new IllegalArgumentException("Invalid board: multiple winners");
        }

        if (xWins) return 'X';
        if (oWins) return 'O';
        return '-';
    }

    private static boolean hasWinner(List<Character> board, char player) {
        return WIN_COMBINATIONS.stream()
                .anyMatch(combo -> combo.stream()
                        .allMatch(i -> board.get(i) == player));
    }
}
