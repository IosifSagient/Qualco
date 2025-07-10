package com.example.qualco.controller;

import com.example.qualco.repository.CountryLanguageRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/countries")
@CrossOrigin(origins = "*")
public class CountryLanguageController {

    private final CountryLanguageRepository repository;

    public CountryLanguageController(CountryLanguageRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/{id}/languages")
    public List<String> getLanguages(@PathVariable Integer id) {
        return repository.findLanguagesByCountryId(id);
    }
}
