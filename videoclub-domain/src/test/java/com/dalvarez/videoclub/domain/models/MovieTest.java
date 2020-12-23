package com.dalvarez.videoclub.domain.models;

import com.dalvarez.videoclub.domain.utils.Utils;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class MovieTest {

    private static final Logger LOGGER = LoggerFactory.getLogger(MovieTest.class);
    private static Validator validator;

    @BeforeAll
    static void setUp() {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        validator = factory.getValidator();
    }

    @Test
    void testMovieValidations() {
        Movie movie = Utils.getDefaultMovie();
        assertTrue(validator.validate(movie).isEmpty());

        LOGGER.info("Movie name validation failed. Details:");
        Movie invalidName1 = Utils.getDefaultMovie();
        invalidName1.setName(null);
        Movie invalidName2 = Utils.getDefaultMovie();
        invalidName2.setName(Utils.ID + Utils.ID);

        validateMovieList(Arrays.asList(invalidName1, invalidName2));

        LOGGER.info("Movie category list validation failed. Details:");
        Movie invalidCategoryList1 = Utils.getDefaultMovie();
        invalidCategoryList1.setCategories(Collections.emptyList());
        Movie invalidCategoryList2 = Utils.getDefaultMovie();
        invalidCategoryList2.setCategories(null);

        validateMovieList(Arrays.asList(invalidCategoryList1, invalidCategoryList2));

        LOGGER.info("Movie registration date validation failed. Details:");
        Movie invalidRegistrationDate = Utils.getDefaultMovie();
        invalidRegistrationDate.setRegistrationDate(LocalDate.of(2018, 12, 19));

        Set<ConstraintViolation<Movie>> constraintViolations = validator.validate(invalidRegistrationDate);
        LOGGER.warn(constraintViolations.toString());
        assertFalse(constraintViolations.isEmpty());

        LOGGER.info("Movie publication date validation failed. Details:");
        Movie invalidPublicationDate = Utils.getDefaultMovie();
        invalidPublicationDate.setPublicationDate(LocalDate.of(2121, 12, 17));

        constraintViolations = validator.validate(invalidPublicationDate);
        LOGGER.warn(constraintViolations.toString());
        assertFalse(constraintViolations.isEmpty());
    }

    void validateMovieList(List<Movie> movieList) {
        movieList.forEach(currentMovie -> {
            Set<ConstraintViolation<Movie>> constraintViolations = validator.validate(currentMovie);
            assertFalse(constraintViolations.isEmpty());
            constraintViolations.stream()
                    .map(Object::toString)
                    .forEach(LOGGER::warn);
        });
    }

}
