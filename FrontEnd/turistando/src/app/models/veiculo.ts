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
}
