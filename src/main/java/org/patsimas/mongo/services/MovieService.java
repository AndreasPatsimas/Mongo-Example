package org.patsimas.mongo.services;

import org.patsimas.mongo.dto.MovieDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface MovieService {

    List<MovieDto> fetchAll();
}
