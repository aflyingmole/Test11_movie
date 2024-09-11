package com.example;

import com.example.dto.CommentsDto;
import com.example.entity.Movie;
import com.example.service.CommentsService;
import com.example.service.MovieService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Commit;
import org.springframework.transaction.annotation.Transactional;

@SpringBootTest
@Transactional
@Commit
public class CommentsServiceTest {
    @Autowired
    private CommentsService cs;
    private MovieService ms;
    @Test
    void save() {
        for (int i = 0; i < 20; i++) {
            cs.addComments(new CommentsDto(0L, 2L, "hie" + i, "반갑다e" + i));
        }
    }
    @Test
    void delete() {
        cs.deleteComments(1L);
    }
}
