import { Combustiveis } from "./Combustiveis";


export class Veiculo {
  placa!: string;
  marca!: string;
  modelo!: string;
  anoFabricacao!: number;
  anoModelo!: number;
  motorizacao!: number;
  capacidadeTanque!: number;
  combustiveisAceitos!: Combustiveis;
  cor!: string;
  renavam!: number;

  constructor(placa: string, marca: string, modelo: string, anoFabricacao: number, anoModelo: number, motorizacao: number, capacidadeTanque: number, combustiveisAceitos: Combustiveis, cor: string, renavam: number){
    this.placa = placa;
    this.marca = marca;
    this.modelo = modelo;
    this.anoFabricacao = anoFabricacao;
    this.anoModelo = anoModelo;
    this.motorizacao = motorizacao;
    this.capacidadeTanque = capacidadeTanque;
    this.combustiveisAceitos = combustiveisAceitos;
    this.cor = cor;
    this.renavam = renavam;
  }
}
