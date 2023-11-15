package com.cinezrest.cinezrest.services;

import com.cinezrest.cinezrest.dtos.MovieDTO;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface MovieService {
    public MovieDTO saveMovie(MovieDTO movieDTO);
    public List<MovieDTO> getMovies();
    public Optional<MovieDTO> getMovieById(Long id);
    public Optional<MovieDTO> updateMovieById(Long id, MovieDTO movieDTO);
    public Optional<MovieDTO> updateMoviePatchById(Long id, MovieDTO movieDTO);
    public boolean deleteMobieById(Long id);
}
