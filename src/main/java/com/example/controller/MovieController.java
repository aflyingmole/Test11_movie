package com.example.controller;

import com.example.dto.CommentsDto;
import com.example.entity.Movie;
import com.example.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MovieController {
    @Autowired
    private MovieService movieService;

    @GetMapping("/movie/detail")
    public String detail(@RequestParam("mnum") Long mnum, Model model) {
        model.addAttribute("movie", movieService.select(mnum));
        return "movie/detail";
    }


}
