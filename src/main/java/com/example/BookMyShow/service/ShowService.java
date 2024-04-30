package com.example.BookMyShow.service;

import com.example.BookMyShow.Transformers.ShowTransformer;
import com.example.BookMyShow.dto.Reqdto.ShowEntryDto;
import com.example.BookMyShow.models.Shows;
import com.example.BookMyShow.repo.ShowRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ShowService {

    @Autowired
    private ShowRepo showRepo;
    public String addShow(ShowEntryDto showEntryDto) {
        String result="";
        try{

            Shows show = ShowTransformer.transform(showEntryDto);

            // have to append for update another configuration.

            result = "Added Successfully";
        }
        catch (Exception e){
            result = e.toString();
        }

        return result;
    }
}
