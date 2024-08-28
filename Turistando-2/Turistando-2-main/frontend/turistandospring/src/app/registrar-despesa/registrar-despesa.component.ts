import { Component } from '@angular/core';
import { FormsModule } from '@angular/forms';

@Component({
  selector: 'app-registrar-despesa',
  standalone: true,
  templateUrl: './registrar-despesa.component.html',
  styleUrls: ['./registrar-despesa.component.css'],
  imports: [FormsModule],
})
export class RegistrarDespesaComponent {
  despesa = {
    valor: 0,
    descricao: '',
    categoria: '',
    veiculo: { id: 0 }, // Ajustado para ser um objeto
  };

  // Método para salvar a despesa
  salvar() {
    // Aqui você deve adicionar a lógica para salvar a despesa, por exemplo, fazer uma requisição HTTP para o backend.
    console.log('Despesa salva:', this.despesa);
  }

  // Método para habilitar a edição da despesa
  editar() {
    // Aqui você deve adicionar a lógica para habilitar a edição dos campos.
    // Você pode, por exemplo, definir um estado de edição e permitir que os campos sejam editáveis.
    console.log('Editando despesa:', this.despesa);
  }

  // Método para manipular o envio do formulário
  onSubmit() {
    console.log('Despesa cadastrada:', this.despesa);
    // Dependendo do estado (se está editando ou salvando), você pode chamar salvar ou editar.
  }
}
