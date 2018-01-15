package com.kodilla.sudoku.repository.row;

import com.kodilla.sudoku.board.SudokuCell;
import com.kodilla.sudoku.repository.cell.CellEntity;
import com.kodilla.sudoku.repository.sudoku.SudokuEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity(name = "rows")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class RowEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    private Integer id;

    @OneToMany(targetEntity = CellEntity.class, mappedBy = "row", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<CellEntity> cells = new ArrayList<>();

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "SUDOKU_ID")
    private SudokuEntity sudoku;

    public void addCell(CellEntity cellEntity){
        cells.add(cellEntity);
        cellEntity.setRow(this);
    }
}
