package com.example.BookMyShow.conrollers;

import com.example.BookMyShow.dto.Reqdto.UserEntryDto;
import com.example.BookMyShow.models.User;
import com.example.BookMyShow.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/user")
public class userController {

    @Autowired
    private UserService userService;

    @PostMapping("/add")
    public ResponseEntity<String> addUser(UserEntryDto userEntryDto){
        try{

            String result = userService.addUser(userEntryDto);
            return new ResponseEntity<>(result , HttpStatus.CREATED);

        }
        catch(Exception e) {

            String result = "Inside not in a  loop";
            return new ResponseEntity<>(result , HttpStatus.BAD_REQUEST);

        }
    }


    @ResponseBody
    @GetMapping("/getTickets")
    public String getTickets(){
        return "Inside a generating total number of tickets.";
    }





}
