package com.challenge4.Chapter4.services;

import com.challenge4.Chapter4.model.Film;
import com.challenge4.Chapter4.repository.FilmRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FilmServiceImplemen implements FilmService{
    private final FilmRepository filmRepository;
    @Autowired
    public FilmServiceImplemen(FilmRepository filmRepository){
        this.filmRepository = filmRepository;
    }

    @Override
    public List<Film> findAll() {
        return filmRepository.findAll();
    }

    @Override
    public Film findBysedang_tayang_atau_tidak(String tayangatautidak) {
        Optional<Film> result = filmRepository.findBysedang_tanyang_atau_tidak(tayangatautidak);
        Film film;
        if(result.isPresent()){
            film = result.get();
        }
        else {
            throw new RuntimeException("Could not find film with status tayang atau tida : " + tayangatautidak);
        }
        return film;
    }

    @Override
    public Film findByFilmCode(Integer filmCode) {
        Optional<Film> result = filmRepository.findByFilmCode(filmCode);
        Film film;
        if (result.isPresent()){
            film = result.get();
        }
        else {
            throw new RuntimeException("Could not find film code");
        }
        return film;
    }

    @Override
    public Film save(Film saveFilm) {
        if ((saveFilm.getFilm_name() != null) && !saveFilm.getFilm_name().isEmpty()
                && (saveFilm.getSedang_tanyang_atau_tidak() != null)){
            return filmRepository.save(saveFilm);
        }
        else {
            throw new RuntimeException("Data film tidak lengkap");
        }
    }

    @Override
    public Film update(Film updateFilm) {
        Optional<Film> result = filmRepository.findByFilmCode(updateFilm.getFilm_code());
        Film film;

        if (result.isPresent()){
            film = result.get();
            film.setFilm_code(updateFilm.getFilm_code());
            film.setFilm_name(updateFilm.getFilm_name());
            film.setSedang_tanyang_atau_tidak(updateFilm.getSedang_tanyang_atau_tidak());
            return filmRepository.save(film);
        }
        else {
            throw new RuntimeException("Data yang mau diupdate tidak ditemukan");
        }
    }

    @Override
    public void delete(int film_code) {
        Optional<Film> result = filmRepository.findByFilmCode(film_code);
        if(result.isPresent()){
            filmRepository.delete(result.get());
        }
        else{
            throw new RuntimeException("Data film yang mau di hapus tidak ditemukan");
        }
    }

}
