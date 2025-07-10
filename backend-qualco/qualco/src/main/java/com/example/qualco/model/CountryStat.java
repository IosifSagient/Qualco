package com.example.qualco.model;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;

@Entity
@Table(name = "country_stats")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CountryStat {

    @EmbeddedId
    private CountryStatId id;

    @Column(name = "population")
    private Integer population;

    @Column(name = "gdp", precision = 15, scale = 0)
    private BigDecimal gdp;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("countryId")
    @JoinColumn(name = "country_id", referencedColumnName = "country_id", nullable = false)
    private Country country;
}
