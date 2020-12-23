package com.dalvarez.videoclub_rest_web.dtos;

import com.dalvarez.videoclub.domain.models.Movie;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class BasicMovieDto {

    private String description;

    public Movie toMovie(String id, BasicMovieDto basicMovieDto) {
        return Movie.builder()
                .id(id)
                .description(basicMovieDto.getDescription())
                .build();
    }

}
