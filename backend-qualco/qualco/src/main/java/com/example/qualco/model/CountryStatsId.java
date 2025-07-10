package com.example.qualco.model;

import lombok.*;

import java.io.Serializable;
import java.util.Objects;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CountryStatsId implements Serializable {

    private Integer country;
    private Integer year;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof CountryStatsId that)) return false;
        return Objects.equals(country, that.country) && Objects.equals(year, that.year);
    }

    @Override
    public int hashCode() {
        return Objects.hash(country, year);
    }
}
