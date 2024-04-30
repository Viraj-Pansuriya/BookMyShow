package com.example.BookMyShow.dto.Reqdto;

import com.example.BookMyShow.models.Movie;
import com.example.BookMyShow.models.Theater;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

import java.sql.Time;
import java.util.Date;

public class ShowEntryDto {


    private Time time;
    private Date date;
    private int movie_id;
    private int theater_id;
    public Time getTime() {
        return time;
    }

    public void setTime(Time time) {
        this.time = time;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public int getMovie_id() {
        return movie_id;
    }

    public void setMovie_id(int movie_id) {
        this.movie_id = movie_id;
    }

    public int getTheater_id() {
        return theater_id;
    }

    public void setTheater_id(int theater_id) {
        this.theater_id = theater_id;
    }
}
