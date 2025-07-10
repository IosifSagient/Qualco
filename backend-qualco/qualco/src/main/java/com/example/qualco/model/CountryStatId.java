package com.example.qualco.model;

import jakarta.persistence.Embeddable;
import lombok.*;

import java.io.Serializable;

@Embeddable
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CountryStatId implements Serializable {

    private Integer countryId;
    private Integer year;
}
