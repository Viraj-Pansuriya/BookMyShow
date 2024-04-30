package com.example.BookMyShow.service;

import com.example.BookMyShow.Transformers.ShowTransformer;
import com.example.BookMyShow.dto.Reqdto.ShowEntryDto;
import com.example.BookMyShow.dto.Reqdto.ShowSeatDto;
import com.example.BookMyShow.models.*;
import com.example.BookMyShow.repo.MovieRepo;
import com.example.BookMyShow.repo.ShowRepo;
import com.example.BookMyShow.repo.TheaterRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ShowService {

    @Autowired
    private ShowRepo showRepo;
    @Autowired
    private MovieRepo movieRepo; 
    @Autowired
    private TheaterRepo theaterRepo; 
    public String addShow(ShowEntryDto showEntryDto) {
        String result="";
        try{
            Shows show = ShowTransformer.transform(showEntryDto);

            int movie_id = showEntryDto.getMovie_id();
            int theater_id = showEntryDto.getTheater_id();

            Optional<Movie> movie = movieRepo.findById(movie_id);
            Optional<Theater> theater = theaterRepo.findById(theater_id); 
            
            if(movie.isEmpty()){
                return "Movie is not present"; 
            }
            if(theater.isEmpty()){
                return "Theater is not present"; 
            }

            // finding movie and theater.
            Movie curr_movie = movie.get();
            Theater curr_theater = theater.get();

            // set details in object.
            show.setMovie(curr_movie);
            show.setTheater(curr_theater);

            // append current show in movie and theater list.
            curr_movie.getShowList().add(show);
            curr_theater.getShowList().add(show);

            // save all this things to database.
            showRepo.save(show);
            movieRepo.save(curr_movie);
            theaterRepo.save(curr_theater);

            return "Show Added Successfully";
        }
        catch (Exception e){
            result = e.toString();
        }

        return result;
    }

    public String addSeat(ShowSeatDto showSeatDto) {

        String result = "";

        try{
        int show_id = showSeatDto.getShowId();
        int premiumSeatPrice = showSeatDto.getPriceOfPremiumSeat();
        int classicSeatPrice = showSeatDto.getPriceOfClassicSeat();

        Optional<Shows> temp_show = showRepo.findById(show_id);
        Shows show = temp_show.get();

        List< TheaterSeat > theaterSeatList = show.getTheater().getTheaterSeatList();
        List <ShowSeat> showSeatList = show.getShowSeatList();
        for(TheaterSeat theaterSeat : theaterSeatList){

            ShowSeat showSeat = new ShowSeat();
            showSeat.setSeatNo(theaterSeat.getSeatNo());
            showSeat.setShow(show);
            showSeat.setSeatType(theaterSeat.getSeatType());
            showSeat.setAvailable(true);
            if(showSeat.getSeatType().equals("PREMIUM")) showSeat.setPrice(premiumSeatPrice);
            else showSeat.setPrice(classicSeatPrice);
            showSeat.setFoodContains(false);

            showSeatList.add(showSeat);

            result = "Successfully added seat for current show";

        }
        showRepo.save(show);
        }
        catch (Exception e){
            result = e.toString();
        }
        return result;

    }
}
