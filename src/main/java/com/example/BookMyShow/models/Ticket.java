package com.example.BookMyShow.models;

import jakarta.persistence.*;

import java.util.Date;

public class Ticket {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int ID;
    private int totalprice;
    private int numberofSeats;

    private Date bookedAt;

    @ManyToOne
    @JoinColumn
    private Show show;

    @ManyToOne
    @JoinColumn
    private User user;

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public int getTotalprice() {
        return totalprice;
    }

    public void setTotalprice(int totalprice) {
        this.totalprice = totalprice;
    }

    public int getNumberofSeats() {
        return numberofSeats;
    }

    public void setNumberofSeats(int numberofSeats) {
        this.numberofSeats = numberofSeats;
    }

    public Date getBookedAt() {
        return bookedAt;
    }

    public void setBookedAt(Date bookedAt) {
        this.bookedAt = bookedAt;
    }

    public Show getShow() {
        return show;
    }

    public void setShow(Show show) {
        this.show = show;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Ticket(int ID, int totalprice, int numberofSeats, Date bookedAt, Show show, User user) {
        this.ID = ID;
        this.totalprice = totalprice;
        this.numberofSeats = numberofSeats;
        this.bookedAt = bookedAt;
        this.show = show;
        this.user = user;
    }
}
