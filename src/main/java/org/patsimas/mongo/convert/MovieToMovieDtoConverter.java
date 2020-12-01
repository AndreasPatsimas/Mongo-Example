package org.patsimas.mongo.convert;

import org.patsimas.mongo.domain.Movie;
import org.patsimas.mongo.dto.MovieDto;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class MovieToMovieDtoConverter implements Converter<Movie, MovieDto> {

    @Override
    public MovieDto convert(Movie movie) {
        return MovieDto.builder()
                .id(movie.getId())
                .title(movie.getTitle())
                .genre(movie.getGenre())
                .director(movie.getDirector())
                .year(movie.getYear())
                .revenue(movie.getRevenue())
                .build();
    }
}
