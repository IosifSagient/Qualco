package com.example.qualco.service;

import com.example.qualco.model.Country;

import java.util.List;

public interface CountryService {
    List<Country> getAllCountries();
    Country getCountryById(Integer id);
}
