import { Combustiveis } from "./Combustiveis";
import { Veiculo } from "./veiculo";

export class Abastecimento {
    idAbastecimento?: number;
    veiculo!: Veiculo;
    data!: string;  // LocalDate pode ser representado como string no formato ISO (yyyy-MM-dd)
    quilometragem!: number;
    tipoCombustivel!: Combustiveis;
    quantidadeCombustivel!: number;
    valorTotal!: number;
}

