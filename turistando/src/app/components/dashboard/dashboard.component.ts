import { Component } from '@angular/core';
import { CarroslistComponent } from '../carroslist/carroslist.component';

@Component({
  selector: 'app-dashboard',
  standalone: true,
  imports: [CarroslistComponent],
  templateUrl: './dashboard.component.html',
  styleUrl: './dashboard.component.css'
})
export class DashboardComponent {

}
