package com.example.qualco.controller;


import com.example.qualco.dto.CountryDTO;
import com.example.qualco.repository.CountryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/countries")
@CrossOrigin(origins = "*")
public class CountryController {
    private final CountryRepository countryRepository;

    public CountryController(CountryRepository countryRepository) {
        this.countryRepository = countryRepository;
    }
    @GetMapping
    public List<CountryDTO> getAllCountries() {
        return countryRepository.findAll().stream()
                .map(CountryDTO::from)
                .toList();
    }
}
