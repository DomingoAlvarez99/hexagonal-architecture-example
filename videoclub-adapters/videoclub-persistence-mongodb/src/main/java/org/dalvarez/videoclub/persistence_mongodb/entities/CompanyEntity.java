package org.dalvarez.videoclub.persistence_mongodb.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CompanyEntity {

    @Id
    private String id;

    private String name;

    private String tradeName;

}
