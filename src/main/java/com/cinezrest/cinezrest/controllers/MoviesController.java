package com.cinezrest.cinezrest.controllers;

import com.cinezrest.cinezrest.dtos.MovieDTO;
import com.cinezrest.cinezrest.services.MovieService;
import com.cinezrest.cinezrest.services.MovieServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/movies")
public class MoviesController {

    @Autowired
    MovieService movieService;

    @GetMapping
    public ResponseEntity getMovies() {
        List<MovieDTO> movieDTOList = movieService.getMovies();
        return new ResponseEntity(movieDTOList, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity addMovie(@RequestBody MovieDTO movieDTO) {
        return new ResponseEntity("Movies", HttpStatus.OK);
    }
}
