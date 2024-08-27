import { Component } from '@angular/core';
import { FormsModule } from '@angular/forms';

@Component({
  selector: 'app-registrar-abastecimento',
  standalone: true,
  templateUrl: './registrar-abastecimento.component.html',
  styleUrls: ['./registrar-abastecimento.component.css'],
  imports: [FormsModule]
})
export class RegistrarAbastecimentoComponent {
  abastecimento = {
    quilometragem: 0,
    valor: 0,
    quantidade: 0,
    combustivelEnum: '',
    veiculoId: 0
  };


  onSubmit() {
    console.log('Abastecimento cadastrado: ', this.abastecimento)
  }
}
