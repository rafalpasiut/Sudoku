package com.kodilla.sudoku.repository.row;

import org.springframework.data.repository.CrudRepository;

public interface RowEntityDao extends CrudRepository<RowEntity, Integer>{

    @Override
    RowEntity save(RowEntity entity);
}
