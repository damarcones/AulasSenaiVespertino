import { Component, OnInit } from '@angular/core';
import { RouterOutlet } from '@angular/router';
import { FooterComponent } from './pages/footer/footer.component';
import { MenuComponent } from './pages/menu/menu.component';

@Component({
  selector: 'app-root',
  standalone: true,
  imports: [RouterOutlet,FooterComponent,MenuComponent],
  templateUrl: './app.component.html',
  styleUrl: './app.component.css'
})
export class AppComponent implements OnInit{

  ngOnInit(): void {
      
  }

  title = 'senai';
  result = 0;

  getHelloMessage(): string {
    console.log("Hello XD")
    alert('OLá Mundo')
    return 'Hello World';
  }

  cadastro(): string {
    console.log()
    return 'Hello World';
  }

  soma(a: String, b: String){
    let numA = Number(a); 
    let numB = Number(b);

    console.log(numA + numB)
    return numA + numB;
  }

  
}
