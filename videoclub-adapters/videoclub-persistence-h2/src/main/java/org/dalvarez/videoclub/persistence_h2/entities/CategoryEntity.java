package org.dalvarez.videoclub.persistence_h2.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = CategoryEntity.CATEGORY)
public class CategoryEntity {

    static final String CATEGORY = "category";

    @Id
    private String id;

    @Column(unique = true)
    private String name;

}
