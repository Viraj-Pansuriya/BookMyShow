package com.example.BookMyShow.dto.Resdto;

import com.example.BookMyShow.models.Movie;
import com.example.BookMyShow.models.ShowSeat;
import com.example.BookMyShow.models.Theater;
import com.example.BookMyShow.models.Ticket;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.CascadeType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;

import java.sql.Time;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class AvailableShowResponse {

    private Time time;
    private Date date;
    private String theater_name;
    private String address;
    private List<ShowSeat> showSeatList = new ArrayList<>();

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

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

    public String getTheater_name() {
        return theater_name;
    }

    public void setTheater_name(String theater_name) {
        this.theater_name = theater_name;
    }

    public List<ShowSeat> getShowSeatList() {
        return showSeatList;
    }

    public void setShowSeatList(List<ShowSeat> showSeatList) {
        this.showSeatList = showSeatList;
    }
}
