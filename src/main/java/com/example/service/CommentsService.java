package com.example.service;

import com.example.dto.CommentsDto;
import com.example.dto.PageResultDto;
import com.example.entity.Comments;
import com.example.entity.Movie;
import com.example.repository.CommentsRepository;
import com.example.repository.MovieRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
public class CommentsService {
    @Autowired
    private CommentsRepository cr;
    @Autowired
    private MovieRepository mr;


    public CommentsDto addComments(CommentsDto dto) {
        Movie m = mr.findById(dto.getMnum()).get();
        Comments comm = dto.toEntity(m);
        Comments c = cr.save(comm);
        return new CommentsDto(c);
    }

    public void deleteComments(Long cnum) {
        cr.deleteById(cnum);
    }

//    public List<CommentsDto> list(Long mnum) {
//        List<Comments> list = cr.findByMnum(mnum);
//        List<CommentsDto> list1 = list.stream().map(m -> new CommentsDto(m)).toList();
//        return list1;
//    }

    public PageResultDto list(Long mnum, PageRequest pageable) {
        Page<Comments> list = cr.findByMnum(mnum, pageable);
        List<CommentsDto> list1 = list.stream().map(m -> new CommentsDto(m)).toList();
        PageResultDto pageResultDto = new PageResultDto(list1,list.getNumber(),list.getTotalPages(),5);
        return pageResultDto;
    }
    public void update(CommentsDto dto) {
        Comments comm = cr.findById(dto.getCnum()).get();
        comm.setComments(dto.getComments());
        cr.save(comm);
    }
}


