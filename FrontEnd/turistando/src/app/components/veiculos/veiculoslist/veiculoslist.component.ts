import { Component } from '@angular/core';
import { IVeiculo } from '../../../models/veiculo';
import { Combustiveis } from '../../../models/Combustiveis';
import { RouterLink } from '@angular/router';
import { VeiculoService } from '../../../services/veiculo.service';
import { ToastrService } from 'ngx-toastr';
import { ModelComponent } from '../../iu/model/model.component';

@Component({
  selector: 'app-veiculoslist',
  standalone: true,
  imports: [RouterLink, ModelComponent],
  templateUrl: './veiculoslist.component.html',
  styleUrl: './veiculoslist.component.css'
})
export class VeiculoslistComponent {

  isModelOpen = false ;
  veiculos: IVeiculo[] = [];
  veiculo!: IVeiculo;



  constructor(private veiculoService: VeiculoService, private toastr: ToastrService) { }

  ngOnInit(): void {
    this.getAllVeiculos();
  }

  getAllVeiculos() {
    this.veiculoService.getAllVeiculos().subscribe({
      next: (response) => {
        if (response.data) {
          this.veiculos = response.data;
        }
      },
    });
  }

  loadVeiculo(veiculo: IVeiculo) {
    this.veiculo = veiculo;
    this.openModel();
  }

  deleteVeiculo(id: string) {
    this.veiculoService.deleteVeiculo(id).subscribe({
      next: (response) => {
        this.toastr.success(response.message);
        this.getAllVeiculos();
      },
    });
  }

  openModel() {
    this.isModelOpen = true;
  }

  closeModel() {
    this.isModelOpen = false;
    this.getAllVeiculos();
  }
}
