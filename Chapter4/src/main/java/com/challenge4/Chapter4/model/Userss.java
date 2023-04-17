package com.challenge4.Chapter4.model;

import jakarta.persistence.*;
import lombok.*;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
@Table(name = "users", schema = "public")
public class Userss {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "username")
    private String username;
    @Column(name = "email_address")
    private String email_address;
    @Column(name = "passwords")
    private String passwords;
}
