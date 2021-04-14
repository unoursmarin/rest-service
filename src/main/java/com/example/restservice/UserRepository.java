package com.example.restservice;

import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

interface UserRepository extends JpaRepository<User, Integer> {
    User findById(int id);
}