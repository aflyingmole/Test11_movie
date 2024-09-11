package com.example.service;

import com.example.dto.MovieDto;
import com.example.entity.Movie;
import com.example.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class MovieService {
    @Autowired
    private MovieRepository mr;

    public MovieDto save(MovieDto dto) {
        Movie movie = dto.toEntity();
        return new MovieDto(mr.save(movie));
    }

    public MovieDto select(long mnum) {
        Movie movie = mr.findById(mnum).get();
        return new MovieDto(movie);
    }
    public List<MovieDto> movieList() {
        List<Movie> mList = mr.findAll();
        return mList.stream().map(MovieDto::new).toList();
    }
}
