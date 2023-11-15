package com.cinezrest.cinezrest.controllers;

import com.cinezrest.cinezrest.config.SecurityConfig;
import com.cinezrest.cinezrest.dtos.MovieDTO;
import com.cinezrest.cinezrest.dtos.PersonDTO;
import com.cinezrest.cinezrest.enums.PersonType;
import com.cinezrest.cinezrest.services.MovieServiceImpl;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.jayway.jsonpath.JsonPath;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Import;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithAnonymousUser;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.sql.Time;
import java.util.ArrayList;
import java.util.List;

import static net.bytebuddy.matcher.ElementMatchers.is;
import static org.hamcrest.Matchers.hasSize;
import static org.hibernate.Hibernate.get;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.web.servlet.function.ServerResponse.status;


@ExtendWith(SpringExtension.class)
@WebMvcTest(value = MoviesController.class)
@Import(SecurityConfig.class)
class MoviesControllerTest {

    @Autowired
    MockMvc mockMvc;

    @Autowired
    ObjectMapper objectMapper;

    @MockBean
    MovieServiceImpl movieService;

    @Test
    @WithAnonymousUser
    void getAllMovies() throws Exception {
        Long movieId = 1L;
        MovieDTO expectedMovie = new MovieDTO();
        expectedMovie.setId(movieId);

        when(movieService.getMovies()).thenReturn(List.of(expectedMovie));
        mockMvc.perform(MockMvcRequestBuilders.get("/api/movies")
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].id", Matchers.is(1)))
                .andExpect(MockMvcResultMatchers.jsonPath("$", Matchers.hasSize(1)))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    @WithAnonymousUser
    void saveMovie() throws Exception {
        MovieDTO movieDTO = MovieDTO.builder()
                .title("Filme Teste")
                .description("Meu filme de teste que testa")
                .releaseYear("2023")
                .movieDuration(new Time(0,120,0))
                .rating(1.5)
                .language("PT-BR")
                .directorList(List.of(
                        PersonDTO.builder()
                                .name("Test Director")
                                .id((long) 1)
                                .personType(PersonType.DIRECTOR)
                                .movies(List.of())
                                .build()
                ))
                .castList(
                        List.of(
                                PersonDTO.builder()
                                        .name("Test ACTOR")
                                        .id((long) 2)
                                        .personType(PersonType.ACTOR)
                                        .movies(List.of())
                                        .build()
                        )
                )
                .build();

        mockMvc.perform(MockMvcRequestBuilders.post("/api/movies")
                .accept(MediaType.APPLICATION_JSON)
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(movieDTO)))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }
}