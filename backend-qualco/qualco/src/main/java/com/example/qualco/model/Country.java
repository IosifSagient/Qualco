package com.example.qualco.model;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "countries")
@NoArgsConstructor
@AllArgsConstructor
public class Country {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "country_id")
    private Integer countryId;

    @Column(name = "name", length = 50)
    private String name;

    @Column(name = "area", nullable = false, precision = 10, scale = 2)
    private BigDecimal area;

    @Column(name = "national_day")
    private LocalDate nationalDay;

    @Column(name = "country_code2", nullable = false, unique = true, length = 2)
    private String countryCode2;

    @Column(name = "country_code3", nullable = false, unique = true, length = 3)
    private String countryCode3;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "region_id", nullable = false)
    private Region region;



    public Integer getCountryId() {
        return countryId;
    }

    public String getName() {
        return name;
    }

    public BigDecimal getArea() {
        return area;
    }

    public String getCountryCode2() {
        return countryCode2;
    }
}
