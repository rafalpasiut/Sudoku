package com.kodilla.sudoku.repository.cell;

import org.springframework.data.repository.CrudRepository;

public interface CellEntityDao extends CrudRepository<CellEntity, Integer> {

    @Override
    CellEntity save(CellEntity entity);
}
