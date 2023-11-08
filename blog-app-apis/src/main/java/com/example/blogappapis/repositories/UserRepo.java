package com.example.blogappapis.repositories;

import com.example.blogappapis.entites.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<User,Integer> {
}
