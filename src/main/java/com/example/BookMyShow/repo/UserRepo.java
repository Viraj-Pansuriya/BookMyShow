package com.example.BookMyShow.repo;

import com.example.BookMyShow.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<User, Integer> {


}
