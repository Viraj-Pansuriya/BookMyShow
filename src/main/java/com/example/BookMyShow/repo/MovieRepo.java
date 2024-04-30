package com.example.BookMyShow.repo;

import com.example.BookMyShow.models.Movie;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MovieRepo extends JpaRepository<Movie , Integer> {
}
