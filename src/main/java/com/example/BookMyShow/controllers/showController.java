package com.example.BookMyShow.controllers;


import com.example.BookMyShow.dto.Reqdto.ShowEntryDto;
import com.example.BookMyShow.dto.Reqdto.ShowSeatDto;
import com.example.BookMyShow.service.ShowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

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

    @PostMapping("/addSeat")
    public ResponseEntity<String> addSeat(ShowSeatDto showSeatDto){

        try{
            String result = showService.addSeat(showSeatDto);
            return new ResponseEntity<>(result , HttpStatus.CREATED);
        }

        catch (Exception e){
            String result = "Problem in adding seat for show";
            return new ResponseEntity<>(result , HttpStatus.NOT_FOUND);

        }

    }










}
