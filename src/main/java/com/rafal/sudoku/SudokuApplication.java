package com.rafal.sudoku;

import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SudokuApplication {

    public static void main(String[] args) {
        //SpringApplication.run(SudokuApplication.class, args);
		SudokuSolver solver;
		int[][] sudoku = new int[][]{
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

		solver = new SudokuSolver(sudoku);
		try {
            solver.solve();
        } catch(CantSolveException e){
            System.out.println("Can`t solve your sudoku");
        }

        for(int i=0;i<9;i++){
            for(int j=0;j<9;j++){
                System.out.print(sudoku[i][j] + "\t");
            }
            System.out.println();
        }
    }
}
