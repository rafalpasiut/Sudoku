package com.rafal.sudoku.solver;

import com.rafal.sudoku.Sudoku;

public class SudokuSolver {

    private Sudoku sudoku;

    public SudokuSolver(Sudoku sudoku) {
        this.sudoku = sudoku;
    }

    public Sudoku solve() throws CantSolveException {    //TODO add time execution watcher which breaks calculations after timeout
        for (int i = 0; i < sudoku.getSudokuLength(); i++) {
            for (int j = 0; j < sudoku.getSudokuLength(); ) {
                if (!sudoku.draftNumbersContains(i, j)) {
                    if (!setNumber(i, j)) {
                        int[] steps = stepBack(i, j);
                        i = steps[0];
                        j = steps[1];
                        if (i < 0) {
                            throw new CantSolveException();
                        }
                    } else {
                        j++;
                    }
                } else {
                    j++;
                }
            }
        }
        return this.sudoku;
    }

    private boolean setNumber(int i, int j) {
        for (int n = sudoku.getValueAtIndex(i, j) + 1; n < 10; n++) {
            if (checkRow(i, n) && checkColumn(j, n) && checkSquare(i, j, n)) {
                sudoku.setValueAtIndex(i, j, n);
                return true;
            }
        }
        sudoku.setValueAtIndex(i, j, 0);
        return false;
    }

    private boolean checkRow(int i, int value) {
        for (int n : sudoku.getRow(i)) {
            if (n == value) {
                return false;
            }
        }
        return true;
    }

    private boolean checkColumn(int j, int value) {
        for (int n : sudoku.getColumn(j)) {
            if (n == value) {
                return false;
            }
        }
        return true;
    }

    private boolean checkSquare(int i, int j, int value) {

        int squareColumn = j / Sudoku.SUDOKU_SQUARE_SIZE;
        int squareRow = i / Sudoku.SUDOKU_SQUARE_SIZE;
        int[] square = new int[sudoku.getSudokuLength()];

        for (int ii = 0; ii < Sudoku.SUDOKU_SQUARE_SIZE; ii++) {
            System.arraycopy(sudoku.getRow(squareRow * Sudoku.SUDOKU_SQUARE_SIZE + ii), squareColumn * Sudoku.SUDOKU_SQUARE_SIZE, square, ii * Sudoku.SUDOKU_SQUARE_SIZE, Sudoku.SUDOKU_SQUARE_SIZE);
        }
        for (int n : square) {
            if (n == value) {
                return false;
            }
        }
        return true;
    }

    private int[] stepBack(int i, int j) {
        while (true) {
            j--;
            if (j < 0) {
                i--;
                j = sudoku.getSudokuLength() - 1;
                if (i < 0) {
                    return new int[]{i, j};
                }
            }
            if (!sudoku.draftNumbersContains(i, j)) {
                return new int[]{i, j};
            }
        }
    }
}
