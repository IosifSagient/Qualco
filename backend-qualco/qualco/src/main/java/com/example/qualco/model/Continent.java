package com.example.qualco.model;

import jakarta.persistence.*;
import lombok.*;


@Entity
@Table(name = "continents")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Continent {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "continent_id")
    private Integer continentId;

    @Column(name = "name", nullable = false, length = 255)
    private String name;
}
