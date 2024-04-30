package com.example.BookMyShow.controllers;

import com.example.BookMyShow.dto.Reqdto.TicketEntryDto;
import com.example.BookMyShow.service.TicketServie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

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
}
