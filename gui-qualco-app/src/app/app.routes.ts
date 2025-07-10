import { Routes } from '@angular/router';
import { HomeComponent } from './pages/home/home.component';
import { CountriesComponent } from './pages/countries/countries.component';
import { CountryLanguageComponent } from './pages/country-languages/country-languages.component';
import { MaxGdpRatioComponent } from './pages/max-gdp-ratio/max-gdp-ratio.component';
import { CountryStatFilterComponent } from './pages/country-stats-filter/country-stat-filter.component';

export const routes: Routes = [
  { path: '', component: HomeComponent },
  { path: 'countries', component: CountriesComponent },
  { path: 'country/:id/languages', component: CountryLanguageComponent },
  { path: 'max-gdp-ratio', component: MaxGdpRatioComponent },
  { path: 'filtered-stats', component: CountryStatFilterComponent },
];
