import { routes } from './../../../app.routes';
import { Veiculo } from './../../../models/veiculo';
import { Component, inject } from '@angular/core';
import { FormsModule } from '@angular/forms';
import {MdbFormsModule} from 'mdb-angular-ui-kit/forms'
import { Combustiveis } from '../../../models/Combustiveis';
import { ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-veiculosdetails',
  standalone: true,
  imports: [MdbFormsModule, FormsModule],
  templateUrl: './veiculosdetails.component.html',
  styleUrl: './veiculosdetails.component.css'
})
export class VeiculosdetailsComponent {

  veiculo: Veiculo = new Veiculo('', '', '', 0, 0, 0, 0, Combustiveis.FLEX, '', 0);
  router = inject(ActivatedRoute);

  constructor(){
    let placa = this.router.snapshot.params['placa'];
    if(placa =! ''){
      this.findByPlaca(placa);
    }
  }

  findByPlaca(placa: string){
    let veiculoRetornado: Veiculo = new Veiculo(placa, 'HONDA', 'CIVIC', 2022, 2022, 1.8, 45.0, Combustiveis.FLEX, 'BRANCO', 12345679856);
    this.veiculo = veiculoRetornado;
  }

  save(){
    alert('salvo')
  }




}
