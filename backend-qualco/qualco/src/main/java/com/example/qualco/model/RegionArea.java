package com.example.qualco.model;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;

@Entity
@Table(name = "region_areas")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class RegionArea {

    @Id
    @Column(name = "region_name", nullable = false, length = 100)
    private String regionName;

    @Column(name = "region_area", nullable = false, precision = 15, scale = 2)
    private BigDecimal regionArea;
}
