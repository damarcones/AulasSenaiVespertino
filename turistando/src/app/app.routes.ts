import { Routes } from '@angular/router';
import { CarroslistComponent } from './components/carroslist/carroslist.component';
import { DashboardComponent } from './components/dashboard/dashboard.component';

export const routes: Routes = [
    {path: "", redirectTo: "dashboard", pathMatch:"full"},
    {path: "dashboard", component: DashboardComponent},
    {path: "carros", component: CarroslistComponent}
];
