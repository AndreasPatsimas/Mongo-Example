package org.patsimas.mongo.convert;

import org.patsimas.mongo.domain.Movie;
import org.patsimas.mongo.dto.MovieDto;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class MovieDtoToMovieConverter implements Converter<MovieDto, Movie> {

    @Override
    public Movie convert(MovieDto movieDto) {
        return Movie.builder()
                .id(movieDto.getId())
                .title(movieDto.getTitle())
                .genre(movieDto.getGenre())
                .director(movieDto.getDirector())
                .year(movieDto.getYear())
                .revenue(movieDto.getRevenue())
                .build();
    }
}
