import { ComponentFixture, TestBed } from '@angular/core/testing';

import { CadastroVeiculoComponent } from './cadastro-veiculo.component';

describe('CadastroVeiculoComponent', () => {
  let component: CadastroVeiculoComponent;
  let fixture: ComponentFixture<CadastroVeiculoComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [CadastroVeiculoComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(CadastroVeiculoComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
