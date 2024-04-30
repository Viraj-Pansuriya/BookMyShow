package com.example.BookMyShow.service;

import com.example.BookMyShow.Transformers.UserTransformer;
import com.example.BookMyShow.dto.Reqdto.UserEntryDto;
import com.example.BookMyShow.models.User;
import com.example.BookMyShow.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepo userRepo;

    public String addUser(UserEntryDto userEntryDto) {

        String result="";
        try{
            User user = UserTransformer.transform(userEntryDto);
            userRepo.save(user);
            result = "Added Successfully";
        }
        catch (Exception e){
            result = e.toString();
        }
        return result;
    }

    public List<User> getUsers() {

        List <User>userList = userRepo.findAll();
        return userList;
    }
}
