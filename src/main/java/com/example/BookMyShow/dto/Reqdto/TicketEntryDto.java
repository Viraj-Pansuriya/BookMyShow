package com.example.BookMyShow.dto.Reqdto;


import java.util.ArrayList;
import java.util.List;

public class TicketEntryDto {
    private int show_id;
    private int user_id;
    private List<String> requestSeats = new ArrayList<>();

    public int getShow_id() {
        return show_id;
    }

    public void setShow_id(int show_id) {
        this.show_id = show_id;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public List<String> getRequestSeats() {
        return requestSeats;
    }

    public void setRequestSeats(List<String> requestSeats) {
        this.requestSeats = requestSeats;
    }
}
