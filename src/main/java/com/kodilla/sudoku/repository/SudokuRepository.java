package com.kodilla.sudoku.repository;

import org.springframework.data.repository.CrudRepository;


public interface SudokuRepository extends CrudRepository<SudokuEntity, Integer> {

    @Override
    SudokuEntity save(SudokuEntity sudoku);
}
