import { Component, OnInit, ViewChild } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';
import { MatTableDataSource, MatTableModule } from '@angular/material/table';
import { MatSelectModule } from '@angular/material/select';
import { MatInputModule } from '@angular/material/input';
import { MatButtonModule } from '@angular/material/button';
import { MatPaginator, MatPaginatorModule } from '@angular/material/paginator';
import { MatCardModule } from '@angular/material/card';
import { MatFormFieldModule } from '@angular/material/form-field';
import { MatIconModule } from '@angular/material/icon';
import { RouterModule } from '@angular/router';
import {
  RegionDto,
  CountryStatFilterDto,
  CountryStatsService,
} from '../../services/country-stats.service';

@Component({
  selector: 'app-country-stat-filter',
  standalone: true,
  imports: [
    CommonModule,
    FormsModule,
    MatTableModule,
    MatSelectModule,
    MatInputModule,
    MatButtonModule,
    MatPaginatorModule,
    MatCardModule,
    MatFormFieldModule,
    MatIconModule,
    RouterModule,
  ],
  templateUrl: './country-stat-filter.component.html',
  styleUrl: './country-stat-filter.component.css',
})
export class CountryStatFilterComponent implements OnInit {
  regionId?: number;
  fromYear?: number;
  toYear?: number;

  regions: RegionDto[] = [];
  dataSource = new MatTableDataSource<CountryStatFilterDto>();
  displayedColumns: string[] = [
    'continentName',
    'regionName',
    'countryName',
    'year',
    'population',
    'gdp',
  ];

  @ViewChild(MatPaginator) paginator!: MatPaginator;

  constructor(private statService: CountryStatsService) {}

  ngOnInit(): void {
    this.statService.getAllRegions().subscribe((res) => {
      this.regions = res;
      console.log('Regions loaded:', res);
    });

    this.loadData();
  }

  loadData(): void {
    this.statService
      .getFilteredStats(this.regionId, this.fromYear, this.toYear)
      .subscribe((res) => {
        this.dataSource = new MatTableDataSource(res);
        this.dataSource.paginator = this.paginator;
      });
  }

  clearFilters(): void {
    this.regionId = undefined;
    this.fromYear = undefined;
    this.toYear = undefined;
    this.loadData();
  }
}
