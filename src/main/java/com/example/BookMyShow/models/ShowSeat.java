package com.example.BookMyShow.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;

@Entity
public class ShowSeat {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String seatNo;
    private String seatType;
    private int price;
    private boolean isAvailable;
    private boolean isFoodContains;

    @JsonBackReference
    @ManyToOne
    @JoinColumn
    private Shows show;

    public ShowSeat(int id, String seatNo, String seatType, int price, boolean isAvailable, boolean isFoodContains, Shows show) {
        this.id = id;
        this.seatNo = seatNo;
        this.seatType = seatType;
        this.price = price;
        this.isAvailable = isAvailable;
        this.isFoodContains = isFoodContains;
        this.show = show;
    }

    public ShowSeat() {

    }

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

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void setAvailable(boolean available) {
        isAvailable = available;
    }

    public boolean isFoodContains() {
        return isFoodContains;
    }

    public void setFoodContains(boolean foodContains) {
        isFoodContains = foodContains;
    }

    public Shows getShow() {
        return show;
    }

    public void setShow(Shows show) {
        this.show = show;
    }
}

