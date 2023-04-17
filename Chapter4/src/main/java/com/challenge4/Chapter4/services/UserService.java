package com.challenge4.Chapter4.services;

import com.challenge4.Chapter4.model.Userss;
import org.apache.catalina.User;

import java.util.List;

public interface UserService {
    List<Userss> findAll();
    Userss findByusername(String username);
    Userss findByEmailAddress(String email_address);
    Userss findByPassword(String password);

    Userss save(Userss saveUsers);
    Userss update(Userss updateUserss);
    void delete(String username);
}
