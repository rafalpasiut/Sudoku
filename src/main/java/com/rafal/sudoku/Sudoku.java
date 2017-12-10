package com.rafal.sudoku;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.IntStream;

public class Sudoku {

    public static final int SUDOKU_SQUARE_SIZE = 3;

    private int[][] sudoku;
    private int sudokuLength;
    private ArrayList<Integer> draftNumbersIndexes;

    public Sudoku(int[][] sudoku) {
        this.sudokuLength = sudoku[0].length;
        initSudoku(sudoku);
        this.draftNumbersIndexes = new ArrayList<>();
        setFixedIndexes();
    }

    public boolean draftNumbersContains(int row, int column) {
        return draftNumbersIndexes.contains(row * sudokuLength + column);
    }

    private void setFixedIndexes() {
        for (int i = 0; i < sudokuLength; i++) {
            for (int j = 0; j < sudokuLength; j++) {
                if (sudoku[i][j] != 0) {
                    draftNumbersIndexes.add(i * sudokuLength + j);
                }
            }
        }
    }

    public int getSudokuLength() {
        return sudokuLength;
    }

    public void setValueAtIndex(int row, int column, int value) {
        sudoku[row][column] = value;
    }

    public int getValueAtIndex(int row, int column) {
        return sudoku[row][column];
    }

    public int[] getRow(int row){
        return sudoku[row];
    }

    public int[] getColumn(int column){
        return IntStream.range(0, sudokuLength).map(row -> sudoku[row][column]).toArray();
    }

    private void initSudoku(int[][] sudoku) {
        this.sudoku = new int[sudokuLength][sudokuLength];
        for (int i = 0; i < sudokuLength; i++) {
            System.arraycopy(sudoku[i], 0, this.sudoku[i], 0, sudokuLength);
        }
        draftNumbersIndexes = new ArrayList<>();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Sudoku sudoku1 = (Sudoku) o;

        return Arrays.deepEquals(sudoku, sudoku1.sudoku);
    }

    @Override
    public int hashCode() {
        return Arrays.deepHashCode(sudoku);
    }
}
