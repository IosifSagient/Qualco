package com.example.qualco.repository;

import com.example.qualco.model.CountryLanguage;
import com.example.qualco.model.CountryLanguageId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CountryLanguageRepository extends JpaRepository<CountryLanguage, CountryLanguageId> {

    @Query("""
              SELECT cl.language.language
              FROM CountryLanguage cl
              WHERE cl.country.countryId = :countryId
            """)
    List<String> findLanguagesByCountryId(@Param("countryId") Integer countryId);
}
