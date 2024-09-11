package com.example.dto;

import com.example.entity.Movie;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class MovieDto {
    // Movie 멤버변수값
    // 생성자에서 Movie객체 받아와서 dto 변환
    // dto -> entity로 변환
    private long mnum;
    private String title;
    private String content;
    private String director;

    public MovieDto(Movie movie) {
        this.mnum = movie.getMnum();
        this.title = movie.getTitle();
        this.content = movie.getContent();
        this.director = movie.getDirector();
    }

    public Movie toEntity() {
        return Movie.builder()
                .mnum(mnum)
                .title(title)
                .content(content)
                .director(director)
                .build();
    }
}
