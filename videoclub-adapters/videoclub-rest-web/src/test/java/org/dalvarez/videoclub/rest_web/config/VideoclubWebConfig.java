package org.dalvarez.videoclub.rest_web.config;

import org.dalvarez.videoclub.domain.services.MovieService;
import org.dalvarez.videoclub.rest_web.controllers.MovieController;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableAutoConfiguration
public class VideoclubWebConfig {

    @Bean
    public MovieController movieController(MovieService movieService) {
        return new MovieController(movieService);
    }
}
