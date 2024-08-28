import { Routes } from '@angular/router';
import { PrincipalComponent } from './components/layout/principal/principal.component';

import { AbastecimentoslistComponent } from './components/abastecimentos/abastecimentoslist/abastecimentoslist.component';
import { AbastecimentosdetailsComponent } from './components/abastecimentos/abastecimentosdetails/abastecimentosdetails.component';
import { VeiculoslistComponent } from './components/veiculos/veiculoslist/veiculoslist.component';
import { VeiculosdetailsComponent } from './components/veiculos/veiculosdetails/veiculosdetails.component';

export const routes: Routes = [

  {path: "", redirectTo: "principal", pathMatch:'full'},
  {path: "principal", component: PrincipalComponent, children: [
    {path:"Veiculos", component: VeiculoslistComponent},
    {path:"Veiculos/new", component: VeiculosdetailsComponent},
    {path:"Veiculos/edit/:placa", component: VeiculosdetailsComponent},
    {path:"abastecimentos", component: AbastecimentoslistComponent},
    {path:"abastecimentos/new", component: AbastecimentosdetailsComponent},
    {path:"abastecimentos/edit/:id", component: AbastecimentosdetailsComponent}
  ]}
];
