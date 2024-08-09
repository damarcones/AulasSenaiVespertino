


import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { MenuComponent } from './pages/menu/menu.component';
import { CadastrarveiculoComponent } from './pages/cadastrarveiculo/cadastrarveiculo.component';
import { CadastrarabastecimentoComponent } from './pages/cadastrarabastecimento/cadastrarabastecimento.component';
import { ListarveiculosComponent } from './pages/listarveiculos/listarveiculos.component';

export const routes: Routes = [
    {path: '', component: MenuComponent},
    {path: 'cadastrarveiculo', component: CadastrarveiculoComponent},
    {path: 'cadastrarabastecimento', component:CadastrarabastecimentoComponent},
    {path: 'listarveiculos', component:ListarveiculosComponent}

];

@NgModule({
    exports: [ RouterModule ],
    imports: [ RouterModule.forRoot(routes) ]
  })

export class AppRoutingModule{}