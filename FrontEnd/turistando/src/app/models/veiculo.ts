import { Combustiveis } from "./Combustiveis";


export interface ApiResponse<T>{
  message?: string;
  data: T;
}


export interface IVeiculo {
  placa?: string;
  marca?: string;
  modelo?: string;
  anoFabricacao?: number;
  anoModelo?: number;
  motorizacao?: number;
  capacidadeTanque?: number;
  combustiveisAceitos?: Combustiveis;
  cor?: string;
  renavam?: number;

}
