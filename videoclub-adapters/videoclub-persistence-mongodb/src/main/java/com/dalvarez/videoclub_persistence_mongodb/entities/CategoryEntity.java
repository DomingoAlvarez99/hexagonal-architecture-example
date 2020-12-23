package com.dalvarez.videoclub_persistence_mongodb.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CategoryEntity {

    @Id
    private String id;

    @Indexed(unique = true)
    private String name;

}
