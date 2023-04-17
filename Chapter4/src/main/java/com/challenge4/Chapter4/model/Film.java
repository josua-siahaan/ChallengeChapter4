package com.challenge4.Chapter4.model;

import jakarta.persistence.*;
import lombok.*;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@ToString
@Table(name = "films", schema = "public")
public class Film {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "film_code")
    private int film_code;
    @Column(name = "film_name")
    private String film_name;
    @Column(name = "sedang_tanyang_atau_tidak")
    private Boolean sedang_tanyang_atau_tidak;
}
