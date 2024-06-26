package com.example.BookMyShow.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;

@Entity
public class TheaterSeat {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String seatNo;
    private String seatType;
    @ManyToOne
    @JoinColumn
    @JsonBackReference
    private Theater theater;

    public TheaterSeat(int id, String seatNo, String seatType, Theater theater) {
        this.id = id;
        this.seatNo = seatNo;
        this.seatType = seatType;
        this.theater = theater;
    }

    public TheaterSeat(){}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSeatNo() {
        return seatNo;
    }

    public void setSeatNo(String seatNo) {
        this.seatNo = seatNo;
    }

    public String getSeatType() {
        return seatType;
    }

    public void setSeatType(String seatType) {
        this.seatType = seatType;
    }

    public Theater getTheater() {
        return theater;
    }

    public void setTheater(Theater theater) {
        this.theater = theater;
    }
}


