package com.example.BookMyShow.models;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Builder;

import java.util.ArrayList;
import java.util.List;

@Entity
@Builder
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int ID;

    @Column(nullable = false)
    private String name;
    @Column(unique = true)
    private String email;
    private String mobile;
    private int age;
    private String address;
    private String gender;
    @JsonManagedReference
    @OneToMany(mappedBy = "user" , cascade = CascadeType.ALL )
    private List< Ticket > ticketList = new ArrayList<>();

    public User(){

    };
    public User(int ID, String name, String email, String mobile, int age, String address, String gender , List<Ticket> ticketList) {
        this.ID = ID;
        this.name = name;
        this.email = email;
        this.mobile = mobile;
        this.age = age;
        this.address = address;
        this.gender = gender;
        this.ticketList = ticketList;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public List<Ticket> getTicketList() {
        return ticketList;
    }

    public void setTicketList(List<Ticket> ticketList) {
        this.ticketList = ticketList;
    }
}
