package com.kodilla.sudoku.repository.user;

import org.springframework.data.repository.CrudRepository;

public interface UserEntityDao extends CrudRepository<UserEntity, Integer> {

    @Override
    UserEntity save(UserEntity entity);
}
