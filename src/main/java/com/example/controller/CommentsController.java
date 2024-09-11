package com.example.controller;

import com.example.dto.CommentsDto;
import com.example.dto.PageResultDto;
import com.example.service.CommentsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class CommentsController {
    @Autowired
    private CommentsService service;

    @PostMapping("/comments/insert")
    public ResponseEntity<CommentsDto> insert(@RequestBody CommentsDto dto) {
        CommentsDto commentsDto = service.addComments(dto);
        return ResponseEntity.ok(commentsDto);
    }

    @GetMapping("/comments/list/{mnum}/{page}")
    public ResponseEntity<PageResultDto> list(@PathVariable("mnum") long mnum, @PathVariable("page") int page) {
        PageRequest pageable = PageRequest.of(page, 3, Sort.by("cnum").descending());
        PageResultDto pageResult = service.list(mnum, pageable);
        return new ResponseEntity<>(pageResult, HttpStatus.OK);
    }

    @DeleteMapping("/comments/delete/{cnum}")
    public void delete(@PathVariable("cnum") long cnum) {
        service.deleteComments(cnum);
    }

    @PutMapping("/comments/update")
    public ResponseEntity<String> update(@RequestBody CommentsDto dto) {
       service.update(dto);
        return new ResponseEntity<>("수정완료", HttpStatus.OK);
    }
}
