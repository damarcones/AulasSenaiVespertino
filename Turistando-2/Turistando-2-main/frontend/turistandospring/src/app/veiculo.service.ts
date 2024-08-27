import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { environment } from './environments/environment';


export interface Veiculo {
  placa: string;
  marca: string;
  modelo: string;
  anoModelo: number;
  anoFabricacao: number;
  cor: string;
  renavam: number;
  motorizacao: number;
  capacidadeTanque: number;
}

@Injectable({
  providedIn: 'root'
})
export class VeiculoService {
  private apiUrl = `${environment.apiUrl}/veiculo/cadastrar`;

  constructor(private http: HttpClient) { }

  cadastrarVeiculo(veiculo: Veiculo): Observable<Veiculo> {
    return this.http.post<Veiculo>(this.apiUrl, veiculo);
  }
}
