package com.challenge4.Chapter4.services;

import com.challenge4.Chapter4.model.Film;

import java.util.List;

public interface FilmService {
    List<Film> findAll();

    Film findBysedang_tayang_atau_tidak(String tayangatautidak);

    Film findByFilmCode(Integer filmCode);

    Film save (Film saveFilm);

    Film update(Film updateFilm);

    void delete(int film_code);

}
