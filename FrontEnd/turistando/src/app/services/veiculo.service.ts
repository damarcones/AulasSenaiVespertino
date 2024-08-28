import { ApiResponse, IVeiculo } from './../models/veiculo';
import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';


@Injectable({
  providedIn: 'root'
})
export class VeiculoService {

  private baseUrl = 'http://localhost:8080/api/veiculos';

  constructor(private http: HttpClient) { }

  getAllVeiculos(): Observable<ApiResponse <IVeiculo[]>> {
    return this.http.get<ApiResponse <IVeiculo[]>>(`${this.baseUrl}`);
  }

  getVeiculoByPlaca(placa: string): Observable<ApiResponse <IVeiculo[]>> {
    return this.http.get<ApiResponse <IVeiculo[]>>(`${this.baseUrl}/${placa}`);
  }

  createVeiculo(veiculo: IVeiculo): Observable<any> {
    return this.http.post<IVeiculo>(`${this.baseUrl}`, veiculo);
  }

  updateVeiculo(placa: string, veiculo: IVeiculo): Observable<any> {
    return this.http.put<IVeiculo>(`${this.baseUrl}/${placa}`, veiculo);
  }

  deleteVeiculo(placa: string): Observable<ApiResponse <any>> {
    return this.http.delete<ApiResponse <any>>(`${this.baseUrl}/${placa}`);
  }
}
