import { Component } from '@angular/core';
import { Veiculo } from '../../../models/veiculo';
import { Combustiveis } from '../../../models/Combustiveis';
import { RouterLink } from '@angular/router';

@Component({
  selector: 'app-veiculoslist',
  standalone: true,
  imports: [RouterLink],
  templateUrl: './veiculoslist.component.html',
  styleUrl: './veiculoslist.component.css'
})
export class VeiculoslistComponent {

  lista: Veiculo[] = [];

  
  constructor(){
    this.lista.push(new Veiculo('REM5E77', 'HONDA', 'CIVIC', 2022, 2022, 1.8, 45.0, Combustiveis.FLEX, 'BRANCO', 12345679865));
    this.lista.push(new Veiculo('REM5E97', 'HONDA', 'FIT', 2022, 2022, 1.8, 45.0, Combustiveis.FLEX, 'BRANCO', 12345679885));
    this.lista.push(new Veiculo('REM5E87', 'HONDA', 'CITY', 2022, 2022, 1.8, 45.0, Combustiveis.FLEX, 'BRANCO', 12345679875));
  }

  editar(){

  }

  deleteByid(veiculo: Veiculo){
    if (confirm("Tem certeza que deseja deletar este Veículo ?")) {
      let indice = this.lista.findIndex(x => {return x.placa == x.placa})
      this.lista.splice(indice, 1);
    }
  }
}
