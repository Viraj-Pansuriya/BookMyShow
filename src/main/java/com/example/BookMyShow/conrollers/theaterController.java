package com.example.BookMyShow.conrollers;

import com.example.BookMyShow.dto.Reqdto.TheaterEntryDto;
import com.example.BookMyShow.service.Theaterservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/theater")
public class theaterController {

    @Autowired
    private Theaterservice theaterservice;

    @PostMapping("/add")
    public ResponseEntity<String> addTheater(TheaterEntryDto theaterEntryDto){
        try{
            String result = theaterservice.addTheater(theaterEntryDto);
            return new ResponseEntity<>(result , HttpStatus.CREATED);
        }
        catch(Exception e) {
            String result = "Inside not in a  loop";
            return new ResponseEntity<>(result , HttpStatus.BAD_REQUEST);
        }
    }
}
