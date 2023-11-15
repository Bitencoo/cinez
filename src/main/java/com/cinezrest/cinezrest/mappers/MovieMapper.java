package com.cinezrest.cinezrest.mappers;

import com.cinezrest.cinezrest.dtos.MovieDTO;
import com.cinezrest.cinezrest.entities.Movie;
import org.mapstruct.Mapper;

@Mapper
public interface MovieMapper {
    Movie movieDtoToMovie(MovieDTO movieDTO);
    MovieDTO movieToMovieDto(Movie movie);
}
