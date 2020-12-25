package org.dalvarez.videoclub.persistence_h2.utils;

import org.dalvarez.videoclub.domain.models.Category;
import org.dalvarez.videoclub.domain.models.Company;
import org.dalvarez.videoclub.domain.models.Movie;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;

public class Utils {

    public static final String DEFAULT_MOVIE_ID = "a60dc08f-bc6b-482c-ae90-0c5fb9f198e0";
    public static final String DEFAULT_MOVIE_NAME = "Cars";
    public static final String DEFAULT_MOVIE_DESCRIPTION = "Cars es una película...";
    public static final LocalDate DEFAULT_MOVIE_PUBLICATION_DATE = LocalDate.now();
    public static final LocalDate DEFAULT_MOVIE_REGISTRATION_DATE = LocalDate.now();
    private static final String DEFAULT_CATEGORIES_ELEMENT1_ID = UUID.randomUUID().toString();
    private static final String DEFAULT_CATEGORIES_ELEMENT2_ID = UUID.randomUUID().toString();
    private static final String DEFAULT_CATEGORIES_ELEMENT3_ID = UUID.randomUUID().toString();
    private static final String DEFAULT_COMPANY_ID = UUID.randomUUID().toString();
    public static final String DEFAULT_MOVIES_ELEMENT1_ID = "a60dc08f-bc6b-482c-ae90-0c5fb9f198e1";
    public static final String DEFAULT_MOVIES_ELEMENT2_ID = "a60dc08f-bc6b-482c-ae90-0c5fb9f198e2";
    public static final String DEFAULT_MOVIES_ELEMENT3_ID = "a60dc08f-bc6b-482c-ae90-0c5fb9f198e3";

    public static Movie getDefaultMovie() {
        return Movie.builder()
                .id(DEFAULT_MOVIE_ID)
                .name(DEFAULT_MOVIE_NAME)
                .description(DEFAULT_MOVIE_DESCRIPTION)
                .publicationDate(DEFAULT_MOVIE_PUBLICATION_DATE)
                .registrationDate(DEFAULT_MOVIE_REGISTRATION_DATE)
                .categories(getDefaultCategoryList())
                .company(getDefaultCompany())
                .build();
    }

    public static List<Category> getDefaultCategoryList() {
        return Arrays.asList(
                Category.builder().id(DEFAULT_CATEGORIES_ELEMENT1_ID).name("Acción").build(),
                Category.builder().id(DEFAULT_CATEGORIES_ELEMENT2_ID).name("Carreras").build(),
                Category.builder().id(DEFAULT_CATEGORIES_ELEMENT3_ID).name("Fantasía").build()
        );
    }

    public static Company getDefaultCompany() {
        return Company.builder()
                .id(DEFAULT_COMPANY_ID)
                .name("Pixar Animation Studios")
                .tradeName("Pixar")
                .build();
    }

    public static Movie[] getDefaultMovies() {
        return new Movie[]{
                Movie.builder()
                        .id(DEFAULT_MOVIES_ELEMENT1_ID)
                        .name(DEFAULT_MOVIE_NAME)
                        .description(DEFAULT_MOVIE_DESCRIPTION)
                        .publicationDate(DEFAULT_MOVIE_PUBLICATION_DATE)
                        .registrationDate(DEFAULT_MOVIE_REGISTRATION_DATE)
                        .categories(getDefaultCategoryList())
                        .company(getDefaultCompany())
                        .build(),
                Movie.builder()
                        .id(DEFAULT_MOVIES_ELEMENT2_ID)
                        .name(DEFAULT_MOVIE_NAME)
                        .description(DEFAULT_MOVIE_DESCRIPTION)
                        .publicationDate(DEFAULT_MOVIE_PUBLICATION_DATE)
                        .registrationDate(DEFAULT_MOVIE_REGISTRATION_DATE)
                        .categories(getDefaultCategoryList())
                        .company(getDefaultCompany())
                        .build(),
                Movie.builder()
                        .id(DEFAULT_MOVIES_ELEMENT3_ID)
                        .name(DEFAULT_MOVIE_NAME)
                        .description(DEFAULT_MOVIE_DESCRIPTION)
                        .publicationDate(DEFAULT_MOVIE_PUBLICATION_DATE)
                        .registrationDate(DEFAULT_MOVIE_REGISTRATION_DATE)
                        .categories(getDefaultCategoryList())
                        .company(getDefaultCompany())
                        .build()
        };
    }

}
