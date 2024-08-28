import { Routes } from '@angular/router';
import { CadastroVeiculoComponent } from './cadastro-veiculo/cadastro-veiculo.component';
import { RegistrarAbastecimentoComponent } from './registrar-abastecimento/registrar-abastecimento.component';
import { RegistrarDespesaComponent } from './registrar-despesa/registrar-despesa.component';

export const routes: Routes = [
  { path: 'cadastrar-veiculo', component: CadastroVeiculoComponent },
  { path: 'registrar-abastecimento', component: RegistrarAbastecimentoComponent },
  { path: 'registrar-despesa', component: RegistrarDespesaComponent}
];
