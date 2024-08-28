import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { CadastroVeiculoComponent } from './cadastro-veiculo/cadastro-veiculo.component';
import { RegistrarAbastecimentoComponent } from './registrar-abastecimento/registrar-abastecimento.component';
import { RegistrarDespesaComponent } from './registrar-despesa/registrar-despesa.component';
import { CalcularConsumoMedioComponent } from './calcular-consumo-medio/calcular-consumo-medio.component';
import { ListarVeiculosComponent } from './listar-veiculos/listar-veiculos.component';
import { RelatorioComponent } from './relatorio/relatorio.component';

export const routes: Routes = [
  { path: 'cadastrar-veiculo', component: CadastroVeiculoComponent },
  { path: 'registrar-abastecimento', component: RegistrarAbastecimentoComponent },
  { path: 'registrar-despesa', component: RegistrarDespesaComponent },
  { path: 'calcular-consumo-medio', component: CalcularConsumoMedioComponent },
  { path: 'listar-veiculos', component: ListarVeiculosComponent },
  { path: 'relatorio', component: RelatorioComponent },
// Certifique-se de que essa rota está configurada
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
