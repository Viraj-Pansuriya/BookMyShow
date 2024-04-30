package com.example.BookMyShow.dto.Reqdto;

public class TheaterSeatDto {

    private String address;
    private int noOfSeatInRow;
    private int premiumSeat;
    private int classicSeat;

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getNoOfSeatInRow() {
        return noOfSeatInRow;
    }

    public void setNoOfSeatInRow(int noOfSeatInRow) {
        this.noOfSeatInRow = noOfSeatInRow;
    }

    public int getPremiumSeat() {
        return premiumSeat;
    }

    public void setPremiumSeat(int premiumSeat) {
        this.premiumSeat = premiumSeat;
    }

    public int getClassicSeat() {
        return classicSeat;
    }

    public void setClassicSeat(int classicSeat) {
        this.classicSeat = classicSeat;
    }
}
