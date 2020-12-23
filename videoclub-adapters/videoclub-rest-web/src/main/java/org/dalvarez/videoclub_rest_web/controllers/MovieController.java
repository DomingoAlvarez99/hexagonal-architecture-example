package org.dalvarez.videoclub_rest_web.controllers;

import com.dalvarez.videoclub.domain.models.Movie;
import com.dalvarez.videoclub.domain.services.MovieService;
import org.dalvarez.videoclub_rest_web.dtos.BasicMovieDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(MovieController.MOVIES)
public class MovieController {

    static final String MOVIES = "/movies";

    static final String ID_MAPPING = "/{id}";


    private MovieService movieService;

    public MovieController(MovieService movieService) {
        this.movieService = movieService;
    }

    @GetMapping(ID_MAPPING)
    public ResponseEntity<Movie> readById(@PathVariable("id") String id) {
        return ResponseEntity.ok(movieService.readById(id));
    }

    @GetMapping
    public ResponseEntity<List<Movie>> readAll() {
        return ResponseEntity.ok(movieService.readAll().collect(Collectors.toList()));
    }

    @PostMapping
    public ResponseEntity<Movie> create(@RequestBody Movie movie) {
        return ResponseEntity.ok(movieService.create(movie));
    }

    @PutMapping
    public ResponseEntity<Movie> update(@RequestBody Movie movie) {
        return ResponseEntity.ok(movieService.update(movie));
    }

    @PutMapping(ID_MAPPING)
    public ResponseEntity<Movie> updateDescription(@PathVariable String id, @RequestBody BasicMovieDto basicMovieDto) {
        return ResponseEntity.ok(movieService.updateDescription(id, basicMovieDto.getDescription()));
    }

    @DeleteMapping(ID_MAPPING)
    public ResponseEntity<Void> deleteById(@PathVariable String id) {
        movieService.deleteById(id);

        return ResponseEntity.noContent().build();
    }
}
