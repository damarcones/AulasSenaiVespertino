import { Component } from '@angular/core';

@Component({
  selector: 'app-listarveiculos',
  standalone: true,
  imports: [],
  templateUrl: './listarveiculos.component.html',
  styleUrl: './listarveiculos.component.css'
})
export class ListarveiculosComponent {
  lista(){
    let lista = ['Kombi','\nFusca', "\nParati", "\nCorsa", "\nGol"];
    return lista;
}
}
