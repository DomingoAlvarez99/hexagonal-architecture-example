package com.dalvarez.videoclub.domain.models;

import com.googlecode.jmapper.annotations.JMap;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Company {

    @JMap
    private String id;

    @JMap
    private String name;

    @JMap
    private String tradeName;

}
