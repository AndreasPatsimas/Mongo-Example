package org.patsimas.mongo.dto;

import lombok.*;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class MovieDto {

    private Integer id;
    private String title;
    private List<String> genre;
    private String director;
    private Integer year;
    private Double revenue;
}
