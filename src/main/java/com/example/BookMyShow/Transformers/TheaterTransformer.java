package com.example.BookMyShow.Transformers;

import com.example.BookMyShow.dto.Reqdto.TheaterEntryDto;
import com.example.BookMyShow.models.Theater;

public class TheaterTransformer {


    public static Theater transform(TheaterEntryDto theaterEntryDto) {

        Theater theater = Theater.builder()
                .name(theaterEntryDto.getName())
                .address(theaterEntryDto.getAddress())
                .build();

        return theater;
    }
}
