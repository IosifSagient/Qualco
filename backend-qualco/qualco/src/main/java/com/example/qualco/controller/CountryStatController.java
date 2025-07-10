package com.example.qualco.controller;


import com.example.qualco.dto.CountryStatMaxDto;
import com.example.qualco.repository.CountryStatRepository;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/stats")
@CrossOrigin(origins = "*")
public class CountryStatController {

    private final CountryStatRepository repository;

    public CountryStatController(CountryStatRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/max-gdp-ratio")
    public List<CountryStatMaxDto> getMaxGdpPerPopulation() {
        return repository.findMaxGdpPerPopulationRatio();
    }
}