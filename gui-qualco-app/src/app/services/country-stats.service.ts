import { Injectable } from '@angular/core';
import { HttpClient, HttpParams } from '@angular/common/http';
import { Observable } from 'rxjs';

export interface CountryStatMaxDto {
  name: string;
  countryCode3: string;
  year: number;
  population: number;
  gdp: number;
}

export interface CountryStatFilterDto {
  continentName: string;
  regionName: string;
  countryName: string;
  year: number;
  population: number;
  gdp: number;
}

export interface RegionDto {
  regionId: number;
  name: string;
}

@Injectable({
  providedIn: 'root',
})
export class CountryStatsService {
  private baseUrl = 'http://localhost:8080/api/stats';

  constructor(private http: HttpClient) {}

  getMaxGdpStats(): Observable<CountryStatMaxDto[]> {
    return this.http.get<CountryStatMaxDto[]>(`${this.baseUrl}/max-gdp-ratio`);
  }

  getFilteredStats(
    regionId?: number,
    fromYear?: number,
    toYear?: number
  ): Observable<CountryStatFilterDto[]> {
    let params: any = {};
    if (regionId) params.regionId = regionId;
    if (fromYear) params.fromYear = fromYear;
    if (toYear) params.toYear = toYear;

    return this.http.get<CountryStatFilterDto[]>(
      `http://localhost:8080/api/stats/filtered`,
      { params }
    );
  }

  getAllRegions(): Observable<RegionDto[]> {
    return this.http.get<RegionDto[]>('http://localhost:8080/api/regions');
  }
}
