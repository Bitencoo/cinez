package com.cinezrest.cinezrest.services;

import com.cinezrest.cinezrest.dtos.MovieDTO;
import com.cinezrest.cinezrest.mappers.MovieMapper;
import com.cinezrest.cinezrest.repositories.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class MovieServiceImpl implements MovieService {
    @Autowired
    private MovieRepository movieRepository;
    private MovieMapper movieMapper;

    @Override
    public MovieDTO saveMovie(MovieDTO movieDTO) {
        movieRepository.save(movieMapper.movieDtoToMovie(movieDTO));
        return null;
    }

    @Override
    public List<MovieDTO> getMovies() {
        return movieRepository.findAll().stream().map(movieMapper::movieToMovieDto).collect(Collectors.toList());
    }

    @Override
    public Optional<MovieDTO> getMovieById(Long id) {
        return Optional.empty();
    }

    @Override
    public Optional<MovieDTO> updateMovieById(Long id, MovieDTO movieDTO) {
        return Optional.empty();
    }

    @Override
    public Optional<MovieDTO> updateMoviePatchById(Long id, MovieDTO movieDTO) {
        return Optional.empty();
    }

    @Override
    public boolean deleteMobieById(Long id) {
        return false;
    }
}
