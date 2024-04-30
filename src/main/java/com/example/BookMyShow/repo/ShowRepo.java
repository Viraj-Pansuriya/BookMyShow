package com.example.BookMyShow.repo;

import com.example.BookMyShow.models.Shows;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ShowRepo extends JpaRepository<Shows, Integer> {
}
