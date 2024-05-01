package com.example.BookMyShow.controllers;

import com.example.BookMyShow.dto.Reqdto.TicketEntryDto;
import com.example.BookMyShow.service.TicketServie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/ticket")
public class TicketController {
    @Autowired
    private TicketServie ticketServie;

    @PostMapping("/book")
    public ResponseEntity<String> generateTicket(@RequestBody TicketEntryDto ticketEntryDto){
        String result = ticketServie.generateTicket(ticketEntryDto);
        return new ResponseEntity<>(result , HttpStatus.CREATED);
    }

    @GetMapping("/cancel/{ticket_id}")
    public ResponseEntity<String> cancel(@PathVariable Integer ticket_id){

        try{
            String result = ticketServie.cancel(ticket_id);
            return new ResponseEntity<>(result , HttpStatus.CREATED);
        }
        catch (Exception e){

        }
        return new ResponseEntity<>("Sorry!! Can not cancel tickets" , HttpStatus.BAD_REQUEST);

    }


}
