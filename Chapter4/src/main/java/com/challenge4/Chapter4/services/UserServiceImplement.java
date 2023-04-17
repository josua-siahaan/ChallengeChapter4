package com.challenge4.Chapter4.services;

import com.challenge4.Chapter4.model.Userss;
import com.challenge4.Chapter4.repository.UserRepository;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImplement implements UserService {
    private final UserRepository userRepository;

    @Autowired
    public UserServiceImplement(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public List<Userss> findAll() {
        return userRepository.findAll();
    }

    @Override
    public Userss findByusername(String username) {
        Optional<Userss> result = userRepository.findByusername(username);
        Userss userss;

        if (result.isPresent()){
            userss = result.get();
        }
        else {
            throw new RuntimeException("Could not find user : " + username);
        }
        return userss;
    }

    @Override
    public Userss findByEmailAddress(String email_address) {
        return null;
    }

    @Override
    public Userss findByPassword(String password) {
        return null;
    }

    @Override
    public Userss save(Userss saveUsers) {
        if(saveUsers.getEmail_address() != null
                && saveUsers.getPasswords() != null
                && saveUsers.getUsername() != null){
            return userRepository.save(saveUsers);
        }
        else {
            throw new RuntimeException(("Data user belum lengkap"));
        }
    }

    @Override
    public Userss update(Userss updateUserss) {
        Optional<Userss> result = userRepository.findByusername(updateUserss.getUsername());
        Userss userss;
        if (result.isPresent()){
            userss = result.get();
            userss.setUsername(updateUserss.getUsername());
            userss.setPasswords(updateUserss.getPasswords());
            userss.setEmail_address(updateUserss.getEmail_address());
            return userRepository.save(userss);
        }
        else {
            throw new RuntimeException("Data User tidak ditemukan");
        }
    }

    @Override
    public void delete(String username) {
        Optional<Userss> result = userRepository.findByusername(username);
        if(result.isPresent()){
            userRepository.delete(result.get());
        }
        else {
            throw new RuntimeException("Data user tidak ditemukan");
        }
    }
}
