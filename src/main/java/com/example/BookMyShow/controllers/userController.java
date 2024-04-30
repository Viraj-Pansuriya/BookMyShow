package com.example.BookMyShow.controllers;

import com.example.BookMyShow.dto.Reqdto.UserEntryDto;
import com.example.BookMyShow.models.User;
import com.example.BookMyShow.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @GetMapping("/all")
    public ResponseEntity<List<User>> getUsers(){
        try{

            List<User> users = userService.getUsers();
            return new ResponseEntity<>(users , HttpStatus.OK);
        }
        catch (Exception e){
            return new ResponseEntity<>(null , HttpStatus.NOT_FOUND);
        }
    }

}
