package com.example.BookMyShow.repo;

import com.example.BookMyShow.models.Theater;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TheaterRepo extends JpaRepository<Theater , Integer> {
    Theater findByAddress(String address);
}
