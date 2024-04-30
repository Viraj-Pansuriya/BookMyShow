package com.example.BookMyShow.service;

import com.example.BookMyShow.Transformers.MovieTransformer;
import com.example.BookMyShow.Transformers.UserTransformer;
import com.example.BookMyShow.dto.Reqdto.MovieEntryDto;
import com.example.BookMyShow.models.Movie;
import com.example.BookMyShow.models.User;
import com.example.BookMyShow.repo.MovieRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
}
