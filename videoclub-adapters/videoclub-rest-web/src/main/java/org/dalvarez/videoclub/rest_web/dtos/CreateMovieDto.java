package org.dalvarez.videoclub.rest_web.dtos;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.dalvarez.videoclub.domain.models.Category;
import org.dalvarez.videoclub.domain.models.Company;
import org.dalvarez.videoclub.domain.models.Movie;

import java.time.LocalDate;
import java.util.List;

@Data
@NoArgsConstructor
public class CreateMovieDto {

    private String name;

    private String description;

    private LocalDate publicationDate;

    private Company company;

    private List<Category> categories;

    public Movie toMovie() {
        return Movie.builder()
                .name(getName())
                .description(getDescription())
                .publicationDate(getPublicationDate())
                .company(getCompany())
                .categories(getCategories())
                .build();
    }
}
