import { Component, OnInit } from '@angular/core';
import { MatTableDataSource } from '@angular/material/table';
import {
  CountryStatsService,
  CountryStatMaxDto,
} from '../../services/country-stats.service';
import { MatTableModule } from '@angular/material/table';
import { MatCardModule } from '@angular/material/card';
import { MatToolbarModule } from '@angular/material/toolbar';
import { MatButtonModule } from '@angular/material/button';
import { CommonModule } from '@angular/common';
import { RouterModule } from '@angular/router';

@Component({
  selector: 'app-max-gdp-ratio',
  templateUrl: './max-gdp-ratio.component.html',
  styleUrls: ['./max-gdp-ratio.component.scss'],
  standalone: true,
  imports: [
    CommonModule,
    MatTableModule,
    MatCardModule,
    MatToolbarModule,
    MatButtonModule,
    RouterModule,
  ],
})
export class MaxGdpRatioComponent implements OnInit {
  displayedColumns: string[] = [
    'name',
    'countryCode3',
    'year',
    'population',
    'gdp',
  ];
  dataSource = new MatTableDataSource<CountryStatMaxDto>();

  constructor(private countryStatsService: CountryStatsService) {}

  ngOnInit(): void {
    this.countryStatsService.getMaxGdpStats().subscribe({
      next: (data) => (this.dataSource.data = data),
      error: (err) => console.error('Failed to fetch GDP data', err),
    });
  }
}
