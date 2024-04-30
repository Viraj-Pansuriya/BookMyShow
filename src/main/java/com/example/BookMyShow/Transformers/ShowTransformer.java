package com.example.BookMyShow.Transformers;

import com.example.BookMyShow.dto.Reqdto.ShowEntryDto;
import com.example.BookMyShow.models.Shows;

public class ShowTransformer {


    public static Shows transform(ShowEntryDto showEntryDto) {

        Shows show = Shows.builder()
                .date(showEntryDto.getDate())
                .time(showEntryDto.getTime())
                .build();
        return show;
    }
}
