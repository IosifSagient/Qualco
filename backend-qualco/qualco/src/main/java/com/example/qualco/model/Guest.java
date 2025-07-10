package com.example.qualco.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "guests")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Guest {

    @Id
    @Column(name = "guest_id")
    private Integer guestId;

    @Column(name = "name", nullable = false, length = 100)
    private String name;
}
