package org.patsimas.mongo.controllers;

import lombok.extern.slf4j.Slf4j;
import org.patsimas.mongo.dto.MovieDto;
import org.patsimas.mongo.services.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping(value = "/movies")
@RestController
@Slf4j
public class MovieController {

    @Autowired
    private MovieService movieService;

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    List<MovieDto> all() {

        log.info("Fetch all movies");

        return movieService.fetchAll();
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity saveMovie(@RequestBody MovieDto movieDto) {

        log.info("Save movie {}", movieDto);

        movieService.save(movieDto);

        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    // https://docs.spring.io/spring-data/mongodb/docs/current/reference/html/#reference
}
