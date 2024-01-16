package org.zerock.dao;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.zerock.w2.dao.TodoDAO;
import org.zerock.w2.domain.TodoVO;

import java.time.LocalDate;

public class TodoDAOtests {

    private TodoDAO todoDAO;

    @BeforeEach
    public void ready(){
        todoDAO = new TodoDAO();
    }
    @Test
    public void testTime() throws Exception{
        System.out.println(todoDAO.getTime());
    }
    @Test
    public void testTime2() throws Exception{
        System.out.println(todoDAO.getTime2());
    }
    @Test
    public void testInsert() throws Exception {
        TodoVO todoVO = TodoVO.builder().title("Sample Title...").dueDate(LocalDate.of(2024,01,15)).build();
        todoDAO.insert(todoVO);
    }
    @Test
    public void testSelectOne() throws Exception {
        Long tno = 1L;
        TodoVO vo = todoDAO.SelectOne(tno);
        System.out.println(vo);
    }
    @Test
    public void testDeleteOne() throws Exception {
        Long tno = 1L;
        todoDAO.deleteOne(tno);
    }
    @Test
    public void testUpdateOne() throws Exception {
        TodoVO todoVO = TodoVO.builder()
                .tno(2L)
                .title("Update Sample Title...")
                .dueDate(LocalDate.of(2024,01,15))
                .finished(true)
                .build();

        todoDAO.updateOne(todoVO);


    }
}
