package com.example.BookMyShow.controllers;

import com.example.BookMyShow.dto.Reqdto.MovieEntryDto;
import com.example.BookMyShow.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/movie")
public class movieController {

    @Autowired
    private MovieService movieService;

    @PostMapping("/add")
    public ResponseEntity<String> addMovie(MovieEntryDto movieEntryDto){
        try{
            String result = movieService.addMovie(movieEntryDto);
            return new ResponseEntity<>(result , HttpStatus.CREATED);
        }
        catch(Exception e) {
            String result = "Inside not in a  loop";
            return new ResponseEntity<>(result , HttpStatus.BAD_REQUEST);
        }
    }


}
