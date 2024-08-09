import { Component } from '@angular/core';

@Component({
  selector: 'app-cadastrarveiculo',
  standalone: true,
  imports: [],
  templateUrl: './cadastrarveiculo.component.html',
  styleUrl: './cadastrarveiculo.component.css'
})
export class CadastrarveiculoComponent {

  displayMessage(msg: String) { 
    
    alert('O carro com a placa ' + msg + ' foi cadastrado!'); }
}
