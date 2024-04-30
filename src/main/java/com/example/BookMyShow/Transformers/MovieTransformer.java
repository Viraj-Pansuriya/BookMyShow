package com.example.BookMyShow.Transformers;

import com.example.BookMyShow.dto.Reqdto.MovieEntryDto;
import com.example.BookMyShow.models.Movie;

public class MovieTransformer {
    public static Movie transform(MovieEntryDto movieEntryDto) {

        Movie movie = Movie.builder()
                .MovieName(movieEntryDto.getMovieName())
                .duration(movieEntryDto.getDuration())
                .genre(movieEntryDto.getGenre())
                .language(movieEntryDto.getLanguage())
                .releasedDate(movieEntryDto.getReleasedDate())
                .rating(movieEntryDto.getRating())
                .build();
        return movie;
    }
}
