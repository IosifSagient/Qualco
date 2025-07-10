package com.example.qualco.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class CountrySummaryDTO {
    private String name;
    private Double area;
    private String code2;
}
