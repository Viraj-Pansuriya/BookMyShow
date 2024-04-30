package com.example.BookMyShow.service;

import com.example.BookMyShow.Transformers.TheaterTransformer;
import com.example.BookMyShow.dto.Reqdto.TheaterEntryDto;
import com.example.BookMyShow.models.Theater;
import com.example.BookMyShow.repo.TheaterRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class Theaterservice {

    @Autowired
    private TheaterRepo theaterRepo;
    public String addTheater(TheaterEntryDto theaterEntryDto) {

        String result="";
        try{
            Theater theater = TheaterTransformer.transform(theaterEntryDto);
            theaterRepo.save(theater);
            result = "Added Successfully";
        }
        catch (Exception e){
            result = e.toString();
        }

        return result;
    }
}
