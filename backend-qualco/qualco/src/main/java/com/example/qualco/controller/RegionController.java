package com.example.qualco.controller;

import com.example.qualco.dto.RegionDto;
import com.example.qualco.model.Region;
import com.example.qualco.repository.RegionRepository;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
@CrossOrigin
public class RegionController {

    private final RegionRepository repository;

    public RegionController(RegionRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/regions")
    public List<RegionDto> getAllRegions() {
        return repository.findAll()
                .stream()
                .map(region -> new RegionDto(region.getRegionId(), region.getName()))
                .toList();
    }
}

