package com.example.qualco.impl;

import com.example.qualco.model.Country;
import com.example.qualco.repository.CountryRepository;
import com.example.qualco.service.CountryService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CountryServiceImpl implements CountryService {

    private final CountryRepository countryRepo;

    public CountryServiceImpl(CountryRepository countryRepo) {
        this.countryRepo = countryRepo;
    }

    @Override
    public List<Country> getAllCountries() {
        return countryRepo.findAll();
    }

    @Override
    public Country getCountryById(Integer id) {
        return countryRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Country not found"));
    }
}
