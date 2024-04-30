package com.example.BookMyShow.conrollers;


import com.example.BookMyShow.dto.Reqdto.MovieEntryDto;
import com.example.BookMyShow.dto.Reqdto.ShowEntryDto;
import com.example.BookMyShow.models.User;
import com.example.BookMyShow.service.MovieService;
import com.example.BookMyShow.service.ShowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/show")
public class showController {

    @Autowired
    private ShowService showService;
    @PostMapping("/add")
    public ResponseEntity<String> addShow(ShowEntryDto showEntryDto){
        try{
            String result = showService.addShow(showEntryDto);
            return new ResponseEntity<>(result , HttpStatus.CREATED);
        }
        catch(Exception e) {
            String result = "Inside not in a  loop";
            return new ResponseEntity<>(result , HttpStatus.BAD_REQUEST);
        }
    }




}
