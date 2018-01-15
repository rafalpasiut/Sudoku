package com.kodilla.sudoku.repository.cell;

import com.kodilla.sudoku.repository.row.RowEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity(name = "cells")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CellEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    private Integer id;

    private Integer value;
    private String availableNumbers;
    private Integer rowNumber;
    private Integer columnNumber;

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn (name = "ROW_ID")
    private RowEntity row;
}
