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

        var crossCount = board.stream().filter(c -> c == 'X').count();
        var noughtCount = board.stream().filter(c -> c == 'O').count();

        var difference = Math.abs(crossCount - noughtCount);
        if (difference > 1) {
            throw new IllegalArgumentException("Invalid board: too many Xs or Os");
        }

        if (crossCount + noughtCount < 5) {
            return '-';
        }

        var xWins = hasWinner(board, 'X');
        var oWins = hasWinner(board, 'O');

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
