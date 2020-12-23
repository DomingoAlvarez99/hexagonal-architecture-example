package com.dalvarez.videoclub.domain.config;

import com.dalvarez.videoclub.domain.ports.MoviePersistence;
import com.dalvarez.videoclub.domain.services.MovieService;
import com.dalvarez.videoclub.domain.services.impl.MovieServiceImpl;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableAutoConfiguration
public class VideoclubDomainConfig {

    @Bean
    public MovieService movieService(MoviePersistence moviePersistence) {
        return new MovieServiceImpl(moviePersistence);
    }

}
