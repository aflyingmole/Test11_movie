package com.example.controller;

import com.example.dto.MovieDto;
import com.example.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class HomeController {
    @Autowired
    private MovieService service;

    @GetMapping("/")
    public String home(Model model) {
        model.addAttribute("list", service.movieList());
        return "home";
    }
}
