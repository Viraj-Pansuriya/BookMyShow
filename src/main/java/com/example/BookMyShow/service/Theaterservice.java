package com.example.BookMyShow.service;

import com.example.BookMyShow.Transformers.TheaterTransformer;
import com.example.BookMyShow.dto.Reqdto.TheaterEntryDto;
import com.example.BookMyShow.dto.Reqdto.TheaterSeatDto;
import com.example.BookMyShow.models.Theater;
import com.example.BookMyShow.models.TheaterSeat;
import com.example.BookMyShow.repo.TheaterRepo;
import org.apache.catalina.LifecycleState;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class Theaterservice {

    @Autowired
    private TheaterRepo theaterRepo;
    public String addTheater(TheaterEntryDto theaterEntryDto) { // In order to add Theater.

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

    public String addSeat(TheaterSeatDto theaterSeatDto) { // In order to add TheaterSeat.

        String result = "";

        try{

            // setting of seat in theater.
            int noOfSeatInRow = theaterSeatDto.getNoOfSeatInRow();
            int premium = theaterSeatDto.getPremiumSeat();
            int classic = theaterSeatDto.getClassicSeat();

            Theater theater = theaterRepo.findByAddress(theaterSeatDto.getAddress());
            List< TheaterSeat > theaterSeatList = theater.getTheaterSeatList();

            int curr = 0;
            char ch = 'A';
            // fill premium and classic seat in theater.
            for(int i = 0 ; i < premium ; i++){
                String seatNo = "P-" +  ch + Integer.toString(curr);
                TheaterSeat theaterSeat = new TheaterSeat();
                theaterSeat.setSeatNo(seatNo);
                theaterSeat.setSeatType("PREMIUM");
                theaterSeat.setTheater(theater);
                theaterSeatList.add(theaterSeat);
                curr++;
                if(curr == noOfSeatInRow){
                    curr=0;
                    ch++;
                }
            }
             curr = 0;
             ch = 'A';

            for(int i = 0 ; i < premium ; i++){
                String seatNo = "C-" + ch + Integer.toString(curr);
                TheaterSeat theaterSeat = new TheaterSeat();
                theaterSeat.setSeatNo(seatNo);
                theaterSeat.setSeatType("CLASSIC");
                theaterSeat.setTheater(theater);
                theaterSeatList.add(theaterSeat);
                curr++;
                if(curr == noOfSeatInRow){
                    curr=0;
                    ch++;
                }
            }
            theaterRepo.save(theater);
            return "Seat Added in Theater";
        }
        catch (Exception e){
            result = e.toString();
        }
        return result;
    }
}
