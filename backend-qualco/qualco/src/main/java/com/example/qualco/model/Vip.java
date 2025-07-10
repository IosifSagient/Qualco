package com.example.qualco.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "vips")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Vip {

    @Id
    @Column(name = "vip_id")
    private Integer vipId;

    @Column(name = "name", nullable = false, length = 100)
    private String name;
}
