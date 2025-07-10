package com.example.qualco.dto;

import com.example.qualco.model.Country;
import java.math.BigDecimal;

public record CountryDTO(Integer countryId, String name, BigDecimal area, String countryCode2) {

    public static CountryDTO from(Country country) {
        return new CountryDTO(
                country.getCountryId(),
                country.getName(),
                country.getArea(),
                country.getCountryCode2()
        );
    }
}
