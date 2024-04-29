package com.example.BookMyShow.models;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

public class Theater {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    @Column(unique = true)
    private String address;
    @OneToMany(mappedBy = "theater" , cascade = CascadeType.ALL)
    private List <TheaterSeat > theaterSeatList = new ArrayList<>();
    @OneToMany(mappedBy = "theater" , cascade = CascadeType.ALL)
    private List <Show> showList = new ArrayList<>();

    public Theater(int id, String name, String address, List<TheaterSeat> theaterSeatList, List<Show> showList) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.theaterSeatList = theaterSeatList;
        this.showList = showList;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public List<TheaterSeat> getTheaterSeatList() {
        return theaterSeatList;
    }

    public void setTheaterSeatList(List<TheaterSeat> theaterSeatList) {
        this.theaterSeatList = theaterSeatList;
    }

    public List<Show> getShowList() {
        return showList;
    }

    public void setShowList(List<Show> showList) {
        this.showList = showList;
    }
}
