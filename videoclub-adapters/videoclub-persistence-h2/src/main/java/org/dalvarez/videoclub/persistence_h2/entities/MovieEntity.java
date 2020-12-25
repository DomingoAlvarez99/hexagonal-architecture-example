package org.dalvarez.videoclub.persistence_h2.entities;

import com.googlecode.jmapper.JMapper;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.dalvarez.videoclub.domain.models.Movie;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.time.LocalDate;
import java.util.List;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = MovieEntity.MOVIE)
public class MovieEntity {

    static final String MOVIE = "movie";

    @Id
    private String id;

    private String name;

    private LocalDate publicationDate;

    private String description;

    private LocalDate registrationDate;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "company_id")
    private CompanyEntity company;

    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinTable(name = "movie_category", joinColumns = @JoinColumn(name = "company_id"),
            inverseJoinColumns = @JoinColumn(name = "movie_id"))
    private List<CategoryEntity> categories;

    public static MovieEntity fromMovie(Movie movie) throws ClassCastException {
        return new JMapper<>(MovieEntity.class, Movie.class)
                .getDestination(movie);
    }

    public Movie toMovie() throws ClassCastException {
        return new JMapper<>(Movie.class, MovieEntity.class)
                .getDestination(this);
    }

}
