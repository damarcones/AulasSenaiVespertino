import { ComponentFixture, TestBed } from '@angular/core/testing';

import { RegistrarDespesaComponent } from './registrar-despesa.component';

describe('RegistrarDespesaComponent', () => {
  let component: RegistrarDespesaComponent;
  let fixture: ComponentFixture<RegistrarDespesaComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [RegistrarDespesaComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(RegistrarDespesaComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
