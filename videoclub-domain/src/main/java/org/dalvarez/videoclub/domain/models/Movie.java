package org.dalvarez.videoclub.domain.models;

import com.googlecode.jmapper.annotations.JMap;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.dalvarez.videoclub.domain.models.validators.ListNotEmpty;

import javax.validation.constraints.FutureOrPresent;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PastOrPresent;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.time.LocalDate;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Movie {

    @NotNull
    @Pattern(regexp = "([a-f0-9]{8}(-[a-f0-9]{4}){4}[a-f0-9]{8})")
    @JMap
    private String id;

    @NotNull
    @Size(min = 1, max = 30)
    @JMap
    private String name;

    @NotNull
    @PastOrPresent
    @JMap
    private LocalDate publicationDate;

    @NotEmpty
    @JMap
    private String description;

    @NotNull
    @FutureOrPresent
    @JMap
    private LocalDate registrationDate;

    @NotNull
    @JMap
    private Company company;

    @ListNotEmpty
    @JMap
    private List<Category> categories;

}
