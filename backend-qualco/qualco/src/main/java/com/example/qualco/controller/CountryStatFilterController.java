package com.example.qualco.controller;

import com.example.qualco.dto.CountryStatFilterDto;
import com.example.qualco.impl.CountryStatFilterService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/stats")
@CrossOrigin(origins = "*")
public class CountryStatFilterController {

    private final CountryStatFilterService service;

    public CountryStatFilterController(CountryStatFilterService service) {
        this.service = service;
    }

    @GetMapping("/filtered")
    public List<CountryStatFilterDto> getFilteredStats(
            @RequestParam(required = false) Integer regionId,
            @RequestParam(required = false) Integer fromYear,
            @RequestParam(required = false) Integer toYear
    ) {
        return service.getStats(regionId, fromYear, toYear);
    }
}
