package com.example.qualco.model;

import com.example.qualco.model.Continent;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "regions")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Region {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "region_id")
    private Integer regionId;

    @Column(name = "name", nullable = false, length = 100)
    private String name;

    public Integer getRegionId() {
        return regionId;
    }

    public String getName() {
        return name;
    }

    public Continent getContinent() {
        return continent;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "continent_id", nullable = false)
    private Continent continent;
}

