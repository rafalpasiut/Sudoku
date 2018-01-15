package com.kodilla.sudoku.repository;

import com.kodilla.sudoku.board.SudokuBoard;
import com.kodilla.sudoku.creator.Creator;
import com.kodilla.sudoku.exceptions.NotUniqueCellValue;
import com.kodilla.sudoku.exceptions.WrogInputException;
import com.kodilla.sudoku.repository.mapper.Mapper;
import com.kodilla.sudoku.repository.sudoku.SudokuEntity;
import com.kodilla.sudoku.repository.user.UserEntity;
import com.kodilla.sudoku.repository.user.UserEntityDao;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static com.kodilla.sudoku.processor.GameProcessor.DEBUG_SUDOKU;

@RunWith(SpringRunner.class)
@SpringBootTest
//@Transactional
public class RepositoryTestSuite {

    @Autowired
    UserEntityDao userEntityDao;

    @Test
    public void testSudokuEntity() {
        //Given
        Mapper mapper = new Mapper();

        UserEntity user = new UserEntity();
        user.setEmail("test2@gmail.com");
        user.setPassword("tajne22");

        Creator sudokuCreator = new Creator();
        String line = DEBUG_SUDOKU;
        sudokuCreator.createNewBoard();
        SudokuBoard sudokuBoard = null;

        try {
            sudokuBoard = sudokuCreator.addNumbersToBoard(line);
        } catch (WrogInputException | NotUniqueCellValue e) {
            e.printStackTrace();
        }
        user.addSavedSudoku(mapper.sudokuToSudokuEntity(sudokuBoard));
        //When

        userEntityDao.save(user);

        //Then
        //System.out.println(sudokuDao.findAll());
    }
}
