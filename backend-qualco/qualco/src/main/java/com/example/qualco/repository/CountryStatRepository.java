package com.example.qualco.repository;



import com.example.qualco.dto.CountryStatMaxDto;
import com.example.qualco.model.CountryStat;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import java.util.List;

public interface CountryStatRepository extends CrudRepository<CountryStat, Long> {

    @Query("""
        SELECT new com.example.qualco.dto.CountryStatMaxDto(
            cs.country.name,
            cs.country.countryCode3,
            cs.id.year,
            cs.population,
            cs.gdp
        )
        FROM CountryStat cs
        WHERE (cs.gdp / cs.population) = (
            SELECT MAX(innerCs.gdp / innerCs.population)
            FROM CountryStat innerCs
            WHERE innerCs.country = cs.country
        )
    """)
    List<CountryStatMaxDto> findMaxGdpPerPopulationRatio();
}

