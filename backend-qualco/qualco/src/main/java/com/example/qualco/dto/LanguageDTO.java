package com.example.qualco.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class LanguageDTO {
    private String language;
    private boolean official;
}