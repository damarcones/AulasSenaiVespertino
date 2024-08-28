import { routes } from './../../../app.routes';

import { Component, EventEmitter, inject, Input, Output } from '@angular/core';
import { FormBuilder, FormControl, FormGroup, FormsModule, ReactiveFormsModule, Validators } from '@angular/forms';
import {MdbFormsModule} from 'mdb-angular-ui-kit/forms'
import { VeiculoService } from '../../../services/veiculo.service';
import { ToastrService } from 'ngx-toastr';
import { IVeiculo } from '../../../models/veiculo';

@Component({
  selector: 'app-Veiculosdetails',
  standalone: true,
  imports: [MdbFormsModule, FormsModule, ReactiveFormsModule],
  templateUrl: './Veiculosdetails.component.html',
  styleUrl: './Veiculosdetails.component.css'
})
export class VeiculosdetailsComponent {

  @Input() data: IVeiculo | null = null;
  @Output() onCloseModel = new EventEmitter();

  veiculoForm!: FormGroup;




  constructor(
    private fb: FormBuilder,
    private veiculoService: VeiculoService,
    private toastr: ToastrService
  ) {
    this.veiculoForm = this.fb.group({
      placa: new FormControl('', [Validators.required]),
      marca: new FormControl('', [Validators.required, Validators.email]),
      modelo: new FormControl('', [Validators.required]),
      anoFabricacao: new FormControl('', [Validators.required]),
      anoModelo: new FormControl('', [Validators.required]),
      motorizacao: new FormControl('', [Validators.required]),
      capacidadeTanque: new FormControl('', [Validators.required]),
      combustiveisAceitos: new FormControl('', [Validators.required]),
      cor: new FormControl('', [Validators.required]),
      renavam: new FormControl('', [Validators.required]),
    });
  }


  ngOnInit(): void {
    this.veiculoForm = this.fb.group({
      placa: ['', Validators.required],
      marca: ['', Validators.required],
      modelo: ['', Validators.required],
      anoFabricacao: ['', [Validators.required, Validators.min(1)]],
      anoModelo: ['', [Validators.required, Validators.min(1)]],
      capacidadeTanque: ['', [Validators.required, Validators.min(1)]],
      combustiveisAceitos: ['', Validators.required],
      motorizacao: ['', Validators.required],
      cor: ['', Validators.required],
      renavam: ['', [Validators.required, Validators.min(1)]]
    });
  }

  onClose() {
    this.onCloseModel.emit(false);
  }

  ngOnChanges(): void {
    if (this.data) {
      this.veiculoForm.patchValue({
        placa: this.data.placa,
        marca: this.data.marca,
        modelo: this.data.modelo,
        anoFabricacao: this.data.anoFabricacao,
        anoModelo: this.data.anoModelo,
        motorizacao: this.data.motorizacao,
        capacidadeTanque: this.data.capacidadeTanque,
        combustiveisAceitos: this.data.combustiveisAceitos,
        cor: this.data.cor,
        renavam: this.data.renavam,

      });
    }
  }

  onSubmit() {
    if (this.veiculoForm.valid) {
      if (this.data) {
        this.veiculoService
          .updateVeiculo(this.data.placa as string, this.veiculoForm.value)
          .subscribe({
            next: (response: any) => {
              this.resetVeiculoForm();
              this.toastr.success(response.message);
            },
          });
      } else {
        this.veiculoService.createVeiculo(this.veiculoForm.value).subscribe({
          next: (response: any) => {
            this.resetVeiculoForm();
            this.toastr.success(response.message);
          },
        });
      }
    } else {
      this.veiculoForm.markAllAsTouched();
    }
  }

  resetVeiculoForm() {
    this.veiculoForm.reset();
    this.onClose();
  }
}

