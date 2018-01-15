package com.kodilla.sudoku.repository.mapper;

import com.kodilla.sudoku.board.SudokuBoard;
import com.kodilla.sudoku.board.SudokuCell;
import com.kodilla.sudoku.board.SudokuRow;
import com.kodilla.sudoku.repository.cell.CellEntity;
import com.kodilla.sudoku.repository.row.RowEntity;
import com.kodilla.sudoku.repository.sudoku.SudokuEntity;

public class Mapper {

    public SudokuEntity sudokuToSudokuEntity(SudokuBoard sudoku){

        SudokuEntity sudokuEntity = new SudokuEntity();

        for(SudokuRow row : sudoku.getRows()){
            sudokuEntity.addRows(sudokuRowToRowEntity(row));
        }

        return sudokuEntity;
    }

    public RowEntity sudokuRowToRowEntity(SudokuRow row){

        RowEntity rowEntity = new RowEntity();
        for(SudokuCell cell : row.getCells()){
            rowEntity.addCell(sudokuCellToCellEntity(cell));
        }

        return rowEntity;
    }

    public CellEntity sudokuCellToCellEntity(SudokuCell cell){

        CellEntity cellEntity = new CellEntity();

        cellEntity.setColumnNumber(cell.getColumnNumber());
        cellEntity.setRowNumber(cell.getRowNumber());
        cellEntity.setValue(cell.getValue());
        cellEntity.setAvailableNumbers(cell.getAvailableNumbers().toString());

        return cellEntity;
    }

}
