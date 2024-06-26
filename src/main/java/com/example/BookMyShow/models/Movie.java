package com.example.BookMyShow.models;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Builder;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
@Entity
@Builder
public class Movie {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String MovieName;
    private int duration;
    @Column(scale = 5)
    private Double rating;
    private Date releasedDate;
    private String genre;
    private String language;
    @JsonManagedReference
    @OneToMany(mappedBy = "movie" , cascade = CascadeType.ALL)
    private List<Shows> showList = new ArrayList<>();

    public Movie(){}

    public Movie(int id, String movieName, int duration, Double rating, Date releasedDate, String genre, String language, List<Shows> showList) {
        this.id = id;
        MovieName = movieName;
        this.duration = duration;
        this.rating = rating;
        this.releasedDate = releasedDate;
        this.genre = genre;
        this.language = language;
        this.showList = showList;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMovieName() {
        return MovieName;
    }

    public void setMovieName(String movieName) {
        MovieName = movieName;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public Double getRating() {
        return rating;
    }

    public void setRating(Double rating) {
        this.rating = rating;
    }

    public Date getReleasedDate() {
        return releasedDate;
    }

    public void setReleasedDate(Date releasedDate) {
        this.releasedDate = releasedDate;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public List<Shows> getShowList() {
        return showList;
    }

    public void setShowList(List<Shows> showList) {
        this.showList = showList;
    }
}
