import { ComponentFixture, TestBed } from '@angular/core/testing';

import { CadastrardespesaComponent } from './cadastrardespesa.component';

describe('CadastrardespesaComponent', () => {
  let component: CadastrardespesaComponent;
  let fixture: ComponentFixture<CadastrardespesaComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [CadastrardespesaComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(CadastrardespesaComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
