import { VeiculoService } from "../services/veiculo.service";
import { Combustiveis } from "./Combustiveis";


export class Abastecimento {
    idAbastecimento?: number;
    Veiculo!: VeiculoService;
    data!: string;  // LocalDate pode ser representado como string no formato ISO (yyyy-MM-dd)
    quilometragem!: number;
    tipoCombustivel!: Combustiveis;
    quantidadeCombustivel!: number;
    valorTotal!: number;
}

