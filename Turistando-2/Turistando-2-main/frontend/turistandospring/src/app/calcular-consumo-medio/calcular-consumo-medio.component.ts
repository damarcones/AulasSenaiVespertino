import { HttpClient } from '@angular/common/http';
import { Component } from '@angular/core';
import { FormsModule } from '@angular/forms';

@Component({
  selector: 'app-calcular-consumo-medio',
  standalone: true,
  imports: [FormsModule],
  templateUrl: './calcular-consumo-medio.component.html',
  styleUrls: ['./calcular-consumo-medio.component.css']
})
export class CalcularConsumoMedioComponent {
  placa: string = '';
  consumoMedio: number | null = null;

  constructor(private http: HttpClient) {}

  calcularConsumo() {
    this.http.get<number>(`http://localhost:8080/api/consumo-medio?placa=${this.placa}`).subscribe({
      next: (resultado) => {
        console.log(`Consumo médio calculado pelo backend: ${resultado} km/l`);
        this.consumoMedio = resultado;
      },
      error: (err) => {
        console.error('Erro ao calcular consumo médio', err);
        alert('Erro ao calcular consumo médio.');
      }
    });
  }
}
