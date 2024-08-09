import { ComponentFixture, TestBed } from '@angular/core/testing';

import { CadastrarveiculoComponent } from './cadastrarveiculo.component';

describe('CadastrarveiculoComponent', () => {
  let component: CadastrarveiculoComponent;
  let fixture: ComponentFixture<CadastrarveiculoComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [CadastrarveiculoComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(CadastrarveiculoComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
