package com.rafal.sudoku.solver;

import com.rafal.sudoku.Sudoku;
import org.junit.Assert;
import org.junit.Test;

public class SudokuSolverTestSuite {

    @Test
    public void testSudokuSolvingHardestInTheWorld() {
        //Given
        int[][] sudokuTable = new int[][]{
                {8, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 3, 6, 0, 0, 0, 0, 0},
                {0, 7, 0, 0, 9, 0, 2, 0, 0},
                {0, 5, 0, 0, 0, 7, 0, 0, 0},
                {0, 0, 0, 0, 4, 5, 7, 0, 0},
                {0, 0, 0, 1, 0, 0, 0, 3, 0},
                {0, 0, 1, 0, 0, 0, 0, 6, 8},
                {0, 0, 8, 5, 0, 0, 0, 1, 0},
                {0, 9, 0, 0, 0, 0, 4, 0, 0}
        };

        Sudoku asnwer = new Sudoku(new int[][]{
                {8, 1, 2, 7, 5, 3, 6, 4, 9},
                {9, 4, 3, 6, 8, 2, 1, 7, 5},
                {6, 7, 5, 4, 9, 1, 2, 8, 3},
                {1, 5, 4, 2, 3, 7, 8, 9, 6},
                {3, 6, 9, 8, 4, 5, 7, 2, 1},
                {2, 8, 7, 1, 6, 9, 5, 3, 4},
                {5, 2, 1, 9, 7, 4, 3, 6, 8},
                {4, 3, 8, 5, 2, 6, 9, 1, 7},
                {7, 9, 6, 3, 1, 8, 4, 5, 2}
        });
        Sudoku sudoku = new Sudoku(sudokuTable);
        SudokuSolver solver = new SudokuSolver(sudoku);
        //When
        Sudoku result = null;
        try {
            result = solver.solve();
        } catch (CantSolveException e) {
            System.out.println("Can`t solve your sudoku");
        }

        //Then
        Assert.assertEquals(result, asnwer);
    }

    @Test
    public void testSudokuSolvingAgainstBruteForce() {
        //Given
        int[][] sudokuTable = new int[][]{
                {0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 3, 0, 8, 5},
                {0, 0, 1, 0, 2, 0, 0, 0, 0},
                {0, 0, 0, 5, 0, 7, 0, 0, 0},
                {0, 0, 4, 0, 0, 0, 1, 0, 0},
                {0, 9, 0, 0, 0, 0, 0, 0, 0},
                {5, 0, 0, 0, 0, 0, 0, 7, 3},
                {0, 0, 2, 0, 1, 0, 0, 0, 0},
                {0, 0, 0, 0, 4, 0, 0, 0, 9}
        };

        Sudoku asnwer = new Sudoku(new int[][]{
                {9, 8, 7, 6, 5, 4, 3, 2, 1},
                {2, 4, 6, 1, 7, 3, 9, 8, 5},
                {3, 5, 1, 9, 2, 8, 7, 4, 6},
                {1, 2, 8, 5, 3, 7, 6, 9, 4},
                {6, 3, 4, 8, 9, 2, 1, 5, 7},
                {7, 9, 5, 4, 6, 1, 8, 3, 2},
                {5, 1, 9, 2, 8, 6, 4, 7, 3},
                {4, 7, 2, 3, 1, 9, 5, 6, 8},
                {8, 6, 3, 7, 4, 5, 2, 1, 9}
        });
        Sudoku sudoku = new Sudoku(sudokuTable);
        SudokuSolver solver = new SudokuSolver(sudoku);

        //When
        long startTime = System.currentTimeMillis();
        Sudoku result = null;
        try {
            result = solver.solve();
        } catch (CantSolveException e) {
            System.out.println("Can`t solve your sudoku");
        }
        System.out.println("Resolving sudoku took: " + (System.currentTimeMillis() - startTime) + "ms");
        //Then
        Assert.assertEquals(result, asnwer);
    }
}
