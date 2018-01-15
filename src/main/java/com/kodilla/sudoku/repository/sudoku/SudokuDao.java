package com.kodilla.sudoku.repository.sudoku;

import org.springframework.data.repository.CrudRepository;


public interface SudokuDao extends CrudRepository<SudokuEntity, Integer> {

    @Override
    SudokuEntity save(SudokuEntity sudoku);
}
