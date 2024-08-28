import { Component } from '@angular/core';
import { FormsModule } from '@angular/forms';

@Component({
  selector: 'app-cadastro-veiculo',
  standalone: true,
  templateUrl: './cadastro-veiculo.component.html',
  styleUrls: ['./cadastro-veiculo.component.css'],
  imports: [FormsModule]  // Adicione o FormsModule aqui
})
export class CadastroVeiculoComponent {
  veiculo = {
    placa: '',
    marca: '',
    modelo: '',
    anoModelo: null,
    anoFabricacao: null,
    cor: '',
    renavam: null,
    motorizacao: null,
    capacidadeTanque: null
  };

  onSubmit() {
    // Lógica para manipular o envio do formulário
    console.log('Veículo cadastrado:', this.veiculo);
  }
}
