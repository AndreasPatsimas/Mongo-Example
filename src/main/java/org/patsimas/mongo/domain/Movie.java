package org.patsimas.mongo.domain;

import lombok.*;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.FieldType;
import org.springframework.data.mongodb.core.mapping.MongoId;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Document(collection = "movies")
public class Movie {

    @MongoId(FieldType.OBJECT_ID) // or @Id
    private Integer id;

    private String title;
    private List<String> genre;
    private String director;
    private Integer year;
    private Double revenue;
}
