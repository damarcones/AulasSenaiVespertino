import { ComponentFixture, TestBed } from '@angular/core/testing';

import { RegistrarAbastecimentoComponent } from './registrar-abastecimento.component';

describe('RegistrarAbastecimentoComponent', () => {
  let component: RegistrarAbastecimentoComponent;
  let fixture: ComponentFixture<RegistrarAbastecimentoComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [RegistrarAbastecimentoComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(RegistrarAbastecimentoComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
