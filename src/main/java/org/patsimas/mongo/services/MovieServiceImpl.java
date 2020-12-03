package org.patsimas.mongo.services;

import lombok.extern.slf4j.Slf4j;
import org.patsimas.mongo.domain.Movie;
import org.patsimas.mongo.dto.MovieDto;
import org.patsimas.mongo.repositories.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.ConversionService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
public class MovieServiceImpl implements MovieService {

    private MovieRepository movieRepository;

    private ConversionService conversionService;

    @Autowired
    public MovieServiceImpl(MovieRepository movieRepository, ConversionService conversionService) {
        this.movieRepository = movieRepository;
        this.conversionService = conversionService;
    }

    @Override
    public List<MovieDto> fetchAll() {

        log.info("Fetch all movies process begins");

        List<MovieDto> movies = movieRepository.findAll()
                .stream()
                .map(movie -> conversionService.convert(movie, MovieDto.class))
                .collect(Collectors.toList());

        log.info("Fetch all movies process end");

        return movies;
    }

    @Override
    public void save(MovieDto movieDto) {

        log.info("Save movie process begins");

        Movie movie = conversionService.convert(movieDto, Movie.class);

        movieRepository.save(movie);

        log.info("Save movie process end");
    }
}
