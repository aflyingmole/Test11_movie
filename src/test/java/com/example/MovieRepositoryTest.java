package com.example;

import com.example.entity.Comments;
import com.example.entity.Movie;
import com.example.repository.CommentsRepository;
import com.example.repository.MovieRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.annotation.Commit;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@SpringBootTest
@Transactional
@Commit
public class MovieRepositoryTest {
    @Autowired
    private MovieRepository mr;
    @Autowired
    private CommentsRepository cr;

    @Test
    void list() {
        List<Movie> list = mr.findAll();
        PageRequest pr = PageRequest.of(1, 5);
        list.forEach(m -> {
            System.out.println(m.getMnum() + "," + m.getContent() + "," + m.getDirector());
            System.out.println("<< 댓글 >>");
            Page<Comments> clist = cr.findByMnum(m.getMnum(),pr);
            clist.forEach(c -> {
                System.out.println(c.getCnum() + "," + c.getId() + "," + c.getComments());
            });
            System.out.println("------------------------");
        });
    }
}
