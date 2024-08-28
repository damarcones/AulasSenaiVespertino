import { ComponentFixture, TestBed } from '@angular/core/testing';

import { CadastrarDespesaComponent } from './cadastrar-despesa.component';

describe('CadastrarDespesaComponent', () => {
  let component: CadastrarDespesaComponent;
  let fixture: ComponentFixture<CadastrarDespesaComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [CadastrarDespesaComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(CadastrarDespesaComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
