package com.kodilla.sudoku.repository;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity(name = "sudoku")
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class SudokuEntity {

    public SudokuEntity(String title, String content, String content2) {
        this.title = title;
        this.content = content;
        this.content2 = content2;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    private Integer id;

    @Column(name = "name")
    private String title;

    @Column(name = "description")
    private String content;

    @Column(name = "description2")
    private String content2;
}
