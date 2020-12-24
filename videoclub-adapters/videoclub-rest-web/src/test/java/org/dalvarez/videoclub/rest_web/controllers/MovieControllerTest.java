package org.dalvarez.videoclub.rest_web.controllers;


import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.dalvarez.videoclub.domain.exceptions.NotFoundException;
import org.dalvarez.videoclub.domain.models.Movie;
import org.dalvarez.videoclub.domain.services.MovieService;
import org.dalvarez.videoclub.rest_web.config.TestConfig;
import org.dalvarez.videoclub.rest_web.utils.Utils;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import java.io.IOException;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@TestConfig
public class MovieControllerTest {

    private static MockMvc mockMvc;

    @MockBean
    private MovieService movieService;

    @Value("${server.servlet.contextPath}")
    private String contextPath;

    @BeforeAll
    public static void setUp(@Autowired WebApplicationContext webApplicationContext) {
        mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
    }

    @Test
    void testReadByIdSuccessful() throws Exception {
        Movie expectedMovie = Utils.getDefaultMovie();
        given(movieService.readById(expectedMovie.getId())).willReturn(expectedMovie);

        mockMvc.perform(get(contextPath + MovieController.MOVIES + MovieController.ID_MAPPING, expectedMovie.getId()).contextPath(contextPath))
                .andExpect(status().isOk()).andDo(mvcResult -> {
            String json = mvcResult.getResponse().getContentAsString();
            Movie movie = convertJSONStringToObject(json, Movie.class);

            assertEquals(movie.getId(), expectedMovie.getId());
            assertEquals(movie.getName(), expectedMovie.getName());
            assertEquals(movie.getDescription(), expectedMovie.getDescription());
            assertEquals(movie.getPublicationDate(), expectedMovie.getPublicationDate());
            assertEquals(movie.getRegistrationDate(), expectedMovie.getRegistrationDate());
            assertEquals(movie.getCompany(), expectedMovie.getCompany());
            assertArrayEquals(movie.getCategories().toArray(), expectedMovie.getCategories().toArray());
            assertEquals(movie, expectedMovie);
        });
    }

    @Test
    void testReadByIdExpectedNotFoundExceptionThrown() throws Exception {
        String id = UUID.randomUUID().toString();
        given(movieService.readById(id))
                .willThrow(NotFoundException.class);

        mockMvc.perform(get(contextPath + MovieController.MOVIES + MovieController.ID_MAPPING, id).contextPath(contextPath))
                .andExpect(status().isNotFound());
    }

    public static <T> T convertJSONStringToObject(String json, Class<T> objectClass) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        mapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);

        JavaTimeModule module = new JavaTimeModule();
        mapper.registerModule(module);

        return mapper.readValue(json, objectClass);
    }

}