package com.example.qualco.dto;

import java.math.BigDecimal;

import java.math.BigDecimal;

public class CountryStatMaxDto {
    private String name;
    private String countryCode3;
    private int year;
    private int population;
    private BigDecimal gdp;

    public CountryStatMaxDto(String name, String countryCode3, int year, int population, BigDecimal gdp) {
        this.name = name;
        this.countryCode3 = countryCode3;
        this.year = year;
        this.population = population;
        this.gdp = gdp;
    }

    public String getName() { return name; }
    public String getCountryCode3() { return countryCode3; }
    public int getYear() { return year; }
    public int getPopulation() { return population; }
    public BigDecimal getGdp() { return gdp; }
}

