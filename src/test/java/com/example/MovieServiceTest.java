package com.example;

import com.example.dto.MovieDto;
import com.example.entity.Movie;
import com.example.service.MovieService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Commit;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@SpringBootTest
@Transactional
@Commit
public class MovieServiceTest {
    @Autowired
    MovieService mr;

    //save
    @Test
    void save() {
        mr.save(new MovieDto(0L, "legend", "test", "두더지"));
        mr.save(new MovieDto(0L, "legend2", "test2", "두더지2"));
        mr.save(new MovieDto(0L, "legend3", "test3", "두더지3"));
    }


    //select
    @Test
    void select() {
        MovieDto select = mr.select(1L);
        System.out.println(select);
    }


    //movieList
    @Test
    void movieList() {
        List<MovieDto> list = mr.movieList();
        list.forEach(System.out::println);

    }
}
