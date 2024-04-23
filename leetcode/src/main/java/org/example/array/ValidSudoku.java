package org.example.array;

public class ValidSudoku {
    public Boolean isValidSudoku(char[][] board) {
        // Check rows
        for (int i = 0; i < 9; i++) {
            if (!isValidRow(board, i)) {
                return false;
            }
        }

        // Check columns
        for (int j = 0; j < 9; j++) {
            if (!isValidColumn(board, j)) {
                return false;
            }
        }
        // Check 3x3 boxes
        for (int i = 0; i < 9; i += 3) {
            for (int j = 0; j < 9; j += 3) {
                if (!isValidBox(board, i, j)) {
                    return false;
                }
            }
        }

        return true;
    }

    private boolean isValidColumn(char[][] board, int col) {
        boolean[] seen = new boolean[9];
        for (int i = 0; i < 9; i++) {
            if (!isValidCell(board[i][col], seen)) {
                return false;
            }
        }
        return true;
    }

    private boolean isValidRow(char[][] board, int row) {
        boolean[] seen = new boolean[9];
        for (int j = 0; j < 9; j++) {
            if (!isValidCell(board[row][j], seen)) {
                return false;
            }
        }
        return true;
    }

    private boolean isValidBox(char[][] board, int startRow, int startCol) {
        boolean[] seen = new boolean[9];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (!isValidCell(board[startRow + i][startCol + j], seen)) {
                    return false;
                }
            }
        }
        return true;
    }
    private boolean isValidCell(char cell, boolean[] seen) {
        if (cell == '.') {
            return true;
        }
        int num = cell - '0';
        if (num < 1 || num > 9 || seen[num - 1]) {
            return false;
        }
        seen[num - 1] = true;
        return true;
    }
}
