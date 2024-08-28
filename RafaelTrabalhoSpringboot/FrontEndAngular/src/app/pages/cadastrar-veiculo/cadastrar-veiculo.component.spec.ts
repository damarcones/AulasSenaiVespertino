import { ComponentFixture, TestBed } from '@angular/core/testing';

import { CadastrarVeiculoComponent } from './cadastrar-veiculo.component';

describe('CadastrarVeiculoComponent', () => {
  let component: CadastrarVeiculoComponent;
  let fixture: ComponentFixture<CadastrarVeiculoComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [CadastrarVeiculoComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(CadastrarVeiculoComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
