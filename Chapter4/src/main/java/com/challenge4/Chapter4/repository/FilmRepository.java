package com.challenge4.Chapter4.repository;

import com.challenge4.Chapter4.model.Film;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface FilmRepository extends JpaRepository<Film, Integer> {
    @Query("SELECT f From films f WHERE f.film_code =?1")
    Optional<Film> findByFilmCode(int film_code);

    @Query("SELECT f FROM films f WHERE f.sedang_tanyang_atau_tidak =?1")
    Optional<Film> findBysedang_tanyang_atau_tidak(String sedang_tanyang_atau_tidak);

}
