package com.rafal.sudoku.solver;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.stream.IntStream;

@Component
public class SudokuSolver {

    private static final int SUDOKU_SQUARE_SIZE = 3;

    private int[][] sudoku;
    private int sudokuLength;
    private ArrayList<Integer> fixedNumbers;

    public SudokuSolver() {
    }

    public int[][] solve(int[][] sudoku) throws CantSolveException {    //TODO add time execution watcher which breaks calculations after timeout
        initSudoku(sudoku);
        getFixedNumbers();
        for (int i = 0; i < sudokuLength; i++) {
            for (int j = 0; j < sudokuLength; ) {
                if (!fixedNumbers.contains(i * sudokuLength + j)) {
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

    private void getFixedNumbers() {
        for (int i = 0; i < sudokuLength; i++) {
            for (int j = 0; j < sudokuLength; j++) {
                if (sudoku[i][j] != 0) {
                    fixedNumbers.add(i * sudokuLength + j);
                }
            }
        }
    }

    private boolean setNumber(int i, int j) {
        for (int n = sudoku[i][j] + 1; n < 10; n++) {
            if (checkRow(i, n) && checkColumn(j, n) && checkSquare(i, j, n)) {
                sudoku[i][j] = n;
                return true;
            }
        }
        sudoku[i][j] = 0;
        return false;
    }

    private boolean checkRow(int i, int value) {
        for (int n : sudoku[i]) {
            if (n == value) {
                return false;
            }
        }
        return true;
    }

    private boolean checkColumn(int j, int value) {
        int[] column = IntStream.range(0, sudokuLength).map(i -> sudoku[i][j]).toArray();

        for (int n : column) {
            if (n == value) {
                return false;
            }
        }
        return true;
    }

    private boolean checkSquare(int i, int j, int value) {

        int squareColumn = j / SUDOKU_SQUARE_SIZE;
        int squareRow = i / SUDOKU_SQUARE_SIZE;
        int[] square = new int[sudokuLength];

        for (int ii = 0; ii < SUDOKU_SQUARE_SIZE; ii++) {
            System.arraycopy(sudoku[squareRow * SUDOKU_SQUARE_SIZE + ii], squareColumn * SUDOKU_SQUARE_SIZE, square, ii * SUDOKU_SQUARE_SIZE, SUDOKU_SQUARE_SIZE);
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
                j = sudokuLength - 1;
                if (i < 0) {
                    return new int[]{i, j};
                }
            }
            if (!fixedNumbers.contains(i * sudokuLength + j)) {
                return new int[]{i, j};
            }
        }
    }

    private void initSudoku(int[][] sudoku) {
        sudokuLength = sudoku[0].length;
        this.sudoku = new int[sudokuLength][sudokuLength];
        for (int i = 0; i < sudokuLength; i++) {
            System.arraycopy(sudoku[i], 0, this.sudoku[i], 0, sudokuLength);
        }
        fixedNumbers = new ArrayList<>();
    }
}
