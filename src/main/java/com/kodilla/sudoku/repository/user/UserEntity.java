package com.kodilla.sudoku.repository.user;

import com.kodilla.sudoku.repository.sudoku.SudokuEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity(name = "users")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    private Integer id;

    private String email;
    private String password;

    @OneToMany(targetEntity = SudokuEntity.class, mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<SudokuEntity> savedSudokus = new ArrayList<>();

    public void addSavedSudoku(SudokuEntity sudokuEntity){
        savedSudokus.add(sudokuEntity);
        sudokuEntity.setUser(this);
    }
}
