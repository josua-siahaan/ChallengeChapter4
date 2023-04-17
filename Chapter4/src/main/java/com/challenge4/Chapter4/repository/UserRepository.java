package com.challenge4.Chapter4.repository;

import com.challenge4.Chapter4.model.Userss;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface UserRepository extends JpaRepository<Userss, String> {
    @Query("SELECT f From users f WHERE f.username =?1")
    Optional<Userss> findByusername(String username);

}
