package com.example.codeclan.filesandfolders.repositories;

import com.example.codeclan.filesandfolders.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
