import { Component } from '@angular/core';

@Component({
  selector: 'app-cadastrarabastecimento',
  standalone: true,
  imports: [],
  templateUrl: './cadastrarabastecimento.component.html',
  styleUrl: './cadastrarabastecimento.component.css'
})
export class CadastrarabastecimentoComponent {
    displayMessage(msg: String) { 
      alert('Abastecimento Cadastrado no Veículo ' + msg+ '!'); 
    }
}
