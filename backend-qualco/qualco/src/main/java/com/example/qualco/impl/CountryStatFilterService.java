package com.example.qualco.impl;


import com.example.qualco.dto.CountryStatFilterDto;
import com.example.qualco.repository.CountryStatFilterRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CountryStatFilterService {

    private final CountryStatFilterRepository repository;

    public CountryStatFilterService(CountryStatFilterRepository repository) {
        this.repository = repository;
    }

    public List<CountryStatFilterDto> getStats(Integer regionId, Integer fromYear, Integer toYear) {
        return repository.findByFilters(regionId, fromYear, toYear);
    }
}
