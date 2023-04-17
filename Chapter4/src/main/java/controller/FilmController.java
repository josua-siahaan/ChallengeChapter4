package controller;

import com.challenge4.Chapter4.model.Film;
import com.challenge4.Chapter4.services.FilmService;
import com.challenge4.Chapter4.util.ResponseHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api")
public class FilmController {
    private final FilmService filmService;
    private static final Map<String, Object> mapParams = new HashMap<String, Object>();
    private static final String SUCCES_MSG = "Successfully retrieved data!";

    @Autowired
    public FilmController(FilmService filmService) {
        this.filmService = filmService;
    }

    @GetMapping("/film")
    public ResponseEntity<Object> findAllOrByArgument(
            @RequestParam(value = "sedang_tayang_atau_tidak", required = false) String sedang_tayang_atau_tidak,
            @RequestParam(value = "film_code", required = false) Integer film_code
            ){
        Film filmList = null;
        if(sedang_tayang_atau_tidak != null) {
            filmList = filmService.findBysedang_tayang_atau_tidak(sedang_tayang_atau_tidak);
        }
        else if (film_code != null) {
            filmList = filmService.findByFilmCode(film_code);
        }
        return ResponseHandler.generateResponse(SUCCES_MSG, HttpStatus.OK, filmList);
    }

    @GetMapping("/film/{film_code}")
    public ResponseEntity<Object> findByFilmCode(@PathVariable("film_code") int film_code) {
        Film filmList = null;
        return ResponseHandler.generateResponse(SUCCES_MSG, HttpStatus.OK, filmList);
    }
    @GetMapping("/film/{sedang_tayang_atau_tidak}")
    public ResponseEntity<Object> findByFilmCode(@PathVariable("sedang_tayang_atau_tidak") String sedang_tayang_atau_tidak) {
        Film filmList = null;
        return ResponseHandler.generateResponse(SUCCES_MSG, HttpStatus.OK, filmList);
    }

    @PostMapping("/film")
    public ResponseEntity<Object> save(@RequestBody Film film){
        filmService.save(film);
        return ResponseHandler.generateResponse(SUCCES_MSG, HttpStatus.OK, film);
    }
    @PutMapping("/film")
    public ResponseEntity<Object> update(@RequestBody Film film){
        filmService.update(film);
        return ResponseHandler.generateResponse(SUCCES_MSG, HttpStatus.OK, film);
    }
    @DeleteMapping("/film")
    public ResponseEntity<Object> delete(@PathVariable int film_code){
        filmService.delete(film_code);
        return ResponseHandler.generateResponse(SUCCES_MSG, HttpStatus.OK, film_code);
    }
}
