import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { API_BASE_URL } from '../constants/api.constants';

export interface Country {
  countryId: number;
  name: string;
  area: number;
  countryCode2: string;
}

@Injectable({
  providedIn: 'root',
})
export class CountryService {
  private baseUrl = `${API_BASE_URL}`;

  constructor(private http: HttpClient) {}

  getCountries(): Observable<Country[]> {
    return this.http.get<Country[]>(`${this.baseUrl}/countries`);
  }
}
