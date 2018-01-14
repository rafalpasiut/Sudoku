package com.kodilla.sudoku.repository;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
//@Transactional
public class RepositoryTestSuite {

    @Autowired
    SudokuRepository sudokuRepository;

    @Test
    public void testSudokuEntity(){
        //Given
        SudokuEntity sudokuEntity = new SudokuEntity("test33","test23", "22");

        //When
        for(int i=0;i<100;i++) {
            sudokuRepository.save(new SudokuEntity("test33","test23", "22"));
        }

        //Then
        System.out.println(sudokuRepository.findAll());
    }
}
