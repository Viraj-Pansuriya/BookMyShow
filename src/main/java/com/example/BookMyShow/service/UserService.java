package com.example.BookMyShow.service;

import com.example.BookMyShow.Transformers.UserTransformer;
import com.example.BookMyShow.dto.Reqdto.UserEntryDto;
import com.example.BookMyShow.dto.Resdto.AvailableShowResponse;
import com.example.BookMyShow.dto.Resdto.TicketResponseDto;
import com.example.BookMyShow.models.Movie;
import com.example.BookMyShow.models.Shows;
import com.example.BookMyShow.models.Ticket;
import com.example.BookMyShow.models.User;
import com.example.BookMyShow.repo.MovieRepo;
import com.example.BookMyShow.repo.ShowRepo;
import com.example.BookMyShow.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class UserService {

    @Autowired
    private UserRepo userRepo;
    @Autowired
    private ShowRepo showRepo;
    @Autowired
    private MovieRepo movieRepo;

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

    public List<TicketResponseDto> getTickets(Integer userid) {

        Optional<User> temp_user = userRepo.findById(userid);
        User user = temp_user.get();

        List<Ticket> ticketList = user.getTicketList();

        List<TicketResponseDto> ticketResponseDtoList = new ArrayList<>();

        for(Ticket ticket : ticketList){

            Shows show = ticket.getShow();
            String Movie = show.getMovie().getMovieName();
            String theater = show.getTheater().getName();
            String Adress = show.getTheater().getAddress();

            TicketResponseDto ticketResponseDto = new TicketResponseDto();
            ticketResponseDto.setTotalPrice(ticket.getTotalprice());
            ticketResponseDto.setBookedSeats(ticket.getBookedTickets());
            ticketResponseDto.setMovieName(Movie);
            ticketResponseDto.setTheaterName(theater);
            ticketResponseDto.setAddress(Adress);
            ticketResponseDto.setDate(show.getDate());
            ticketResponseDto.setTime(show.getTime());

            ticketResponseDtoList.add(ticketResponseDto);

        }

        return ticketResponseDtoList;


    }

    public List<AvailableShowResponse> getShows(Integer movie_id) {

        Optional<Movie> temp_movie = movieRepo.findById(movie_id);
        Movie movie = temp_movie.get();

        List < AvailableShowResponse > showsList = new ArrayList<>();

//        HashMap< String , List <AvailableShowResponse > > available_showList = new HashMap<>();

        for(Shows shows : movie.getShowList()){
            if(shows.getBooked() != (int)shows.getTheater().getTheaterSeatList().size()){
                AvailableShowResponse availableShowResponse = new AvailableShowResponse();
                availableShowResponse.setTime(shows.getTime());
                availableShowResponse.setDate(shows.getDate());
                availableShowResponse.setTheater_name(shows.getTheater().getName());
                availableShowResponse.setShowSeatList(shows.getShowSeatList());
                availableShowResponse.setAddress(shows.getTheater().getAddress());
                showsList.add(availableShowResponse);
            }
        }

        return showsList;


    }
}
