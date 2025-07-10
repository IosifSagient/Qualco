package com.example.qualco.model;

import com.example.qualco.model.Country;
import com.example.qualco.model.CountryLanguageId;
import com.example.qualco.model.Language;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "country_languages")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CountryLanguage {

    @EmbeddedId
    private CountryLanguageId id;

    @Column(name = "official", nullable = false)
    private boolean official;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("countryId")
    @JoinColumn(name = "country_id", referencedColumnName = "country_id", nullable = false)
    private Country country;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("languageId")
    @JoinColumn(name = "language_id", referencedColumnName = "language_id", nullable = false)
    private Language language;
}