package com.example.dto;

import com.example.entity.Comments;
import com.example.entity.Movie;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class CommentsDto {
    private Long cnum;
    private Long mnum;
    private String id;
    private String comments;

    public CommentsDto(Comments comments) {
        this.cnum = comments.getCnum();
        this.mnum = comments.getMovie().getMnum();
        this.id = comments.getId();
        this.comments = comments.getComments();
    }

    public Comments toEntity(Movie movie) {
        return Comments.builder()
                .cnum(cnum)
                .movie(movie)
                .id(id)
                .comments(comments)
                .build();
    }

}
