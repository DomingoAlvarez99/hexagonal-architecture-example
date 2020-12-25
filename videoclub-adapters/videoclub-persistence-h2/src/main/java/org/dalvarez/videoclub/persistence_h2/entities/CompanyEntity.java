package org.dalvarez.videoclub.persistence_h2.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = CompanyEntity.COMPANY)
public class CompanyEntity {

    static final String COMPANY = "company";

    @Id
    private String id;

    private String name;

    private String tradeName;

}

