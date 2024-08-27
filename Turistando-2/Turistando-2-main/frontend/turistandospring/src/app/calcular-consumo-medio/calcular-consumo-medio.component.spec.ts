import { ComponentFixture, TestBed } from '@angular/core/testing';

import { CalcularConsumoMedioComponent } from './calcular-consumo-medio.component';

describe('CalcularConsumoMedioComponent', () => {
  let component: CalcularConsumoMedioComponent;
  let fixture: ComponentFixture<CalcularConsumoMedioComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [CalcularConsumoMedioComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(CalcularConsumoMedioComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
