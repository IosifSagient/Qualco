import { HttpClient } from '@angular/common/http';
import { API_BASE_URL } from '../constants/api.constants';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

export interface CountryLanguage {
  language: string;
}

@Injectable({
  providedIn: 'root',
})
export class CountryLanguageService {
  private baseUrl = 'http://localhost:8080/api/countries'; // Or `${API_BASE_URL}/countries` if you define it elsewhere

  constructor(private http: HttpClient) {}

  getLanguagesByCountryId(id: number): Observable<string[]> {
    return this.http.get<string[]>(`${this.baseUrl}/${id}/languages`);
  }
}
