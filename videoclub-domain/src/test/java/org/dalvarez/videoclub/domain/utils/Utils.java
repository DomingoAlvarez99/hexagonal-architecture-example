package org.dalvarez.videoclub.domain.utils;

import org.dalvarez.videoclub.domain.models.Category;
import org.dalvarez.videoclub.domain.models.Company;
import org.dalvarez.videoclub.domain.models.Movie;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;

public class Utils {

    public static final String ID = UUID.randomUUID().toString();
    public static final String NAME = "Cars";
    public static final String DESCRIPTION = "Cars es una película...";
    public static final LocalDate PUBLICATION_DATE = LocalDate.now();
    public static final LocalDate REGISTRATION_DATE = LocalDate.now();

    public static Movie getDefaultMovie() {
        return Movie.builder()
                .id(ID)
                .name(NAME)
                .description(DESCRIPTION)
                .publicationDate(PUBLICATION_DATE)
                .registrationDate(REGISTRATION_DATE)
                .categories(getDefaultCategoryList())
                .company(getDefaultCompany())
                .build();
    }

    public static List<Category> getDefaultCategoryList() {
        return Arrays.asList(
                Category.builder().id(UUID.randomUUID().toString()).name("Acción").build(),
                Category.builder().id(UUID.randomUUID().toString()).name("Carreras").build(),
                Category.builder().id(UUID.randomUUID().toString()).name("Fantasía").build()
        );
    }

    public static Company getDefaultCompany() {
        return Company.builder()
                .id(UUID.randomUUID().toString())
                .name("Pixar Animation Studios")
                .tradeName("Pixar")
                .build();
    }

}
