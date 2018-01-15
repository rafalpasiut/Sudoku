package com.kodilla.sudoku.repository.sudoku;

import com.kodilla.sudoku.board.SudokuRow;
import com.kodilla.sudoku.repository.row.RowEntity;
import com.kodilla.sudoku.repository.user.UserEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity(name = "sudoku")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class SudokuEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    private Integer id;

    @OneToMany(targetEntity = RowEntity.class, mappedBy = "sudoku", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<RowEntity> rows = new ArrayList<>();

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "USER_ID")
    private UserEntity user;

    public void addRows(RowEntity rowEntity){
        rows.add(rowEntity);
        rowEntity.setSudoku(this);
    }
}
