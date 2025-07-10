import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, RouterModule } from '@angular/router';
import { CountryLanguageService } from '../../services/countryLanguage.service';
import { CommonModule } from '@angular/common';
import { MatButtonModule } from '@angular/material/button';
import { MatCardModule } from '@angular/material/card';
import { MatIconModule } from '@angular/material/icon';
import { MatListModule } from '@angular/material/list';

@Component({
  selector: 'app-country-languages',
  standalone: true,
  imports: [
    CommonModule,
    MatCardModule,
    MatListModule,
    MatIconModule,
    MatButtonModule,
    RouterModule,
  ],
  templateUrl: './country-languages.component.html',
  styleUrl: './country-languages.component.css',
})
export class CountryLanguageComponent implements OnInit {
  countryId!: number;
  languages: string[] = [];

  constructor(
    private route: ActivatedRoute,
    private languageService: CountryLanguageService
  ) {}

  ngOnInit(): void {
    this.countryId = +this.route.snapshot.paramMap.get('id')!;
    this.languageService.getLanguagesByCountryId(this.countryId).subscribe({
      next: (data) => {
        this.languages = data;
      },
      error: (err) => console.error('Error fetching languages', err),
    });
  }
}
