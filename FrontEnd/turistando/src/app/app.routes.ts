import { Routes } from '@angular/router';
import { PrincipalComponent } from './components/layout/principal/principal.component';
import { VeiculoslistComponent } from './components/veiculos/veiculoslist/veiculoslist.component';
import { VeiculosdetailsComponent } from './components/veiculos/veiculosdetails/veiculosdetails.component';
import { AbastecimentoslistComponent } from './components/abastecimentos/abastecimentoslist/abastecimentoslist.component';
import { AbastecimentosdetailsComponent } from './components/abastecimentos/abastecimentosdetails/abastecimentosdetails.component';

export const routes: Routes = [

  {path: "", redirectTo: "principal", pathMatch:'full'},
  {path: "principal", component: PrincipalComponent, children: [
    {path:"veiculos", component: VeiculoslistComponent},
    {path:"veiculos/new", component: VeiculosdetailsComponent},
    {path:"veiculos/edit/:placa", component: VeiculosdetailsComponent},
    {path:"abastecimentos", component: AbastecimentoslistComponent},
    {path:"abastecimentos/new", component: AbastecimentosdetailsComponent},
    {path:"abastecimentos/edit/:id", component: AbastecimentosdetailsComponent}
  ]}
];
