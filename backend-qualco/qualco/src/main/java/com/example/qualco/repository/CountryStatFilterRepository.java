package com.example.qualco.repository;

import com.example.qualco.dto.CountryStatFilterDto;
import com.example.qualco.model.CountryStat;
import com.example.qualco.model.CountryStatId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

@org.springframework.stereotype.Repository
public interface CountryStatFilterRepository extends JpaRepository<CountryStat, CountryStatId> {


    @Query("""
                SELECT new com.example.qualco.dto.CountryStatFilterDto(
                    c.region.continent.name,
                    c.region.name,
                    c.name,
                    cs.id.year,
                    cs.population,
                    cs.gdp
                )
                FROM CountryStat cs
                JOIN cs.country c
                WHERE (:regionId IS NULL OR c.region.regionId = :regionId)
                  AND (:fromYear IS NULL OR cs.id.year >= :fromYear)
                  AND (:toYear IS NULL OR cs.id.year <= :toYear)
            """)
    List<CountryStatFilterDto> findByFilters(
            @Param("regionId") Integer regionId,
            @Param("fromYear") Integer fromYear,
            @Param("toYear") Integer toYear
    );

}
