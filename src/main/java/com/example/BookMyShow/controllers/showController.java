package com.example.BookMyShow.controllers;


import com.example.BookMyShow.dto.Reqdto.ShowEntryDto;
import com.example.BookMyShow.dto.Reqdto.ShowSeatDto;
import com.example.BookMyShow.service.ShowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.parameters.P;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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

    @GetMapping("reset/{show_id}")
    public ResponseEntity<String> reset(@PathVariable Integer show_id){

        String result;
        try{
             result = showService.reset(show_id);
            return new ResponseEntity<>(result , HttpStatus.OK);
        }
        catch (Exception e){
            result = e.toString();
        }
        return new ResponseEntity<>(result , HttpStatus.BAD_REQUEST);

    }










}
