package com.example.BookMyShow.models;



import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Builder;

import java.sql.Time;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Builder
public class Shows {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int ID;

    private Time time;

    private Date date;
    @ManyToOne
    @JoinColumn
    private Movie movie;
    @ManyToOne
    @JoinColumn
    private Theater theater;

    @OneToMany(mappedBy = "show" , cascade = CascadeType.ALL)
    private List<ShowSeat> showSeatList = new ArrayList<>();

    @JsonManagedReference
    @OneToMany(mappedBy = "show" , cascade = CascadeType.ALL)
    private List<Ticket> ticketList = new ArrayList<>();

    private Shows(){}

    public Shows(int ID, Time time, Date date, Movie movie, Theater theater, List<ShowSeat> showSeatList, List<Ticket> ticketList) {
        this.ID = ID;
        this.time = time;
        this.date = date;
        this.movie = movie;
        this.theater = theater;
        this.showSeatList = showSeatList;
        this.ticketList = ticketList;
    }

    @Override
    public String toString() {
        return "Shows{" +
                "ID=" + ID +
                ", time=" + time +
                ", date=" + date +
                ", movie=" + movie +
                ", theater=" + theater +
                ", showSeatList=" + showSeatList +
                ", ticketList=" + ticketList +
                '}';
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
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

    public Movie getMovie() {
        return movie;
    }

    public void setMovie(Movie movie) {
        this.movie = movie;
    }

    public Theater getTheater() {
        return theater;
    }

    public void setTheater(Theater theater) {
        this.theater = theater;
    }

    public List<ShowSeat> getShowSeatList() {
        return showSeatList;
    }

    public void setShowSeatList(List<ShowSeat> showSeatList) {
        this.showSeatList = showSeatList;
    }

    public List<Ticket> getTicketList() {
        return ticketList;
    }

    public void setTicketList(List<Ticket> ticketList) {
        this.ticketList = ticketList;
    }
}
