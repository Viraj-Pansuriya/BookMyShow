package com.example.BookMyShow.repo;

import com.example.BookMyShow.models.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TicketRepo extends JpaRepository<Ticket , Integer> {
}
