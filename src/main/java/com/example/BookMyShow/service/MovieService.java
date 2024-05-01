package com.example.BookMyShow.service;

import com.example.BookMyShow.Transformers.MovieTransformer;
import com.example.BookMyShow.Transformers.UserTransformer;
import com.example.BookMyShow.dto.Reqdto.MovieEntryDto;
import com.example.BookMyShow.models.Movie;
import com.example.BookMyShow.models.Shows;
import com.example.BookMyShow.models.Ticket;
import com.example.BookMyShow.models.User;
import com.example.BookMyShow.repo.MovieRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.Optional;

@Service
public class MovieService {

    @Autowired
    private MovieRepo movieRepo;

    public String addMovie(MovieEntryDto movieEntryDto) {
        String result="";
        try{
            Movie movie = MovieTransformer.transform(movieEntryDto);
            movieRepo.save(movie);
            result = "Added Successfully";
        }
        catch (Exception e){
            result = e.toString();
        }

        return result;
    }


    public Long getCollection(Integer movie_id) {

        long ans = 0;
        Optional<Movie> temp_movie = movieRepo.findById(movie_id);
        Movie movie = temp_movie.get();
        System.out.println(movie.getMovieName());
        List < Shows > showsList = movie.getShowList();

        for(Shows shows : showsList){
            List<Ticket> ticketlist = shows.getTicketList();

            for(Ticket ticket : ticketlist){
                ans += ticket.getTotalprice();
            }
        }

        return ans;
    }
}
